// MySQL database test
@GrabConfig(systemClassLoader=true)
@Grab('mysql:mysql-connector-java:5.1.22')
import groovy.sql.*

repo = Sql.newInstance( 'jdbc:mysql://localhost:3306/test', 'root','','com.mysql.jdbc.Driver' )
//def sql2 = Sql.newInstance( 'jdbc:mysql://localhost:3306/test', 'root','','com.mysql.jdbc.Driver' )
target = 'r:/_down/sample-drupal-connection'
target = 'c:/TEMP/sample-drupal-connection'
def nodeSql = """
SELECT n.title, r.body,r.format, n.nid, n.vid, n.type, date_format(FROM_UNIXTIME(created),'%Y-%m-%d %H:%i:%s') created
FROM drupal_node n
JOIN drupal_node_revisions r ON ( n.vid = r.vid )
"""

//new File(target+'/content').deleteDir()

repo.eachRow( nodeSql ) { node ->
	//println "$node.nid -- ${node.title} --" 
	def path = pathFromNode(repo,node)
	create_directories_from(path)
	//println path
	File f  = new File(target+path)
	f.append(meta(node),'UTF-8')
	f.append(content(node),'UTF-8')
	f.append(comments(node),'UTF-8')
}

def comments(node){
	def commentsSql = """
		SELECT nid, subject, comment, name,  
		date_format(FROM_UNIXTIME(c.timestamp),'%Y-%m-%d %H:%i:%s') comment_date
		FROM drupal_comments c
		where nid = ${node.nid}
		order by c.timestamp
		"""
	def rs = repo.rows(commentsSql)
	//println Requirement Specification
	String res = "\n\n<div class='old-comments'>"
	rs.each{comment -> 
		res += """
		<div class='one-old-comment'>
			<span class='comment-date'>${comment.comment_date}</span>
			<span class='commenter-name'>${comment.name}</span>
			<div class='comment-body'>
				<span class='comment-title'>${comment.subject}</comment>
				${comment.comment}
			</div>
		</div>
		"""
	}
	res += "</div>"
	return res
}

def content(node){
	node.body
}

def meta(node){
"""---
title: \"${node.title.replaceAll('\\"','\\\\"')}\"
kind: article
created_at: ${node.created} +0000
author: \"Takács Ottó\"
published: true
tags: ${tags(node)}
---
"""
}

def tags(node){
	def tagsSql = """
	SELECT tn.nid, t.name 
	FROM  drupal_term_data t 
	join drupal_term_node tn on(t.tid = tn.tid)
	where tn.nid=${node.nid}
	"""
	repo.rows(tagsSql).collect{it.name}.unique().join(',')
}

def pathFromNode(lsql, node){
	def xxx = "SELECT * FROM drupal_url_alias alias WHERE alias.src = 'node/"+node.nid+"'";
	def path = lsql.firstRow(xxx).dst
	return '/content/'+cleanup(path)+'.md'
}

def cleanup(path){
	path.replaceAll("’","").replaceAll('”','')
		.replaceAll('„','').replaceAll('–','-')
		.replaceAll('á','a')
}

def create_directories_from (path){
	File f =new File(target+path)
	new File(f.getParent()).mkdirs()
	f.createNewFile();
}



/*
SELECT * FROM drupal_filter_formats
*/