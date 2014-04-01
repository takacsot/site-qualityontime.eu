#Technique

- split into small chunks (see Rothman book)
- make your design draft, or implementation note. Even if Agile says do not go into technical details. And tit can be working for extension of exting system. But as soon as yu have to develop sothing new non existing before and there are no examples before in you project you have to highlight the problem with technical details. Do not forget that the estimation is true in the current version and for the technical solution described. SImple example: imagine tha tyou want to integrate two application running on separate computer. The integrated data iss imple and almost nothing to do. But can you imagine that it has different estimate if the integration is db based, or ftp transfer, or JMS? Can you imagine that it is changing estimate asap you discover that the technology is new to you or not (I have met developer for who ftp based file trasfer was a huge risk because of the lack of Java API knowledge like commons-net).
- mus tknow that estimation is based on the current state of the system. NOt the version next we ek. This is a knownw risk. I have many many bad experience when after given the estimate and client return after  a year to do the stuff and we had to double the estimate because in that year we had to improve the system and the complexity if that feature become much bigger.
- you could learn from you estimates if you track time spent on implementing.   

   
#Estimation measurement units

There are two main:

- story point, and its variation like T-shirt size, and the new fun thing about noestimate (no estimate ha prerequirement like small stories and unified size sotries simply imagine all storey have the size of 1 and small enough to fitt into one sprint so we are truning to story points...)etc
- effort in calendar unit

## story point

- definition
- advantages
- disadvantages


## Effort estimate

Disadvantages:

- slow: because it needs details to be reliable. It can be speed up by introducing a story point concept of Fibanoccy numbers. Team aggree on a certain unit of work like ready in 1 day will have the "point" of 2. Then you could use fibbanoccu number to make esitmate quick. It is a calendar based estimate but the granularity of Fibonacci numbers can give good enough confidential intervall (hicher the number bigger the steps) to reflect risk and volume.
- quickly become unrealistic. See EVO. After each iteration you could reestimate or simply by tracking time then after result just adjust by not started yet stories. Surprisingly easy and effective way to adapt to reality. 
