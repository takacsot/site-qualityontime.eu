---
title: "Do we really need JQuery validator plugin?"
kind: article
created_at: 2014-08-04 01:12
tags:
  - jquery
  - javascript
  - html
  - programming
  - development
---

The more I need to do some HTML client side validation the more I am asking myself whether we need a validation framework or not. 

Until now I have not used any specific validation framework. But now I have to because I do not want to take care of simple syntax level (number field could accept numbers only, etc.) field validation. 

First of all I have used developers best friend: [Google ](https://www.google.lu/search?q=jquery+validation+plugin). I have found numerous validation framework for [JQuery ](http://jquery.com/) (just have a look at the Google search result in the previous links).

I have check many of them and found that most of them are too complicated to my need (remember, I need simple syntax check because complex validation is made on server side).

The client side I wanted to make something simple and declarative:

~~~html
  <form:input path="duration.hour" cssClass="form-control" maxlength="2" data-validation-pattern="^([01]?[0-9]|2[0-3])?$"/>
~~~

This is a simple Spring MVC input field. I have just introduced a custom `data` attribute called  `data-validation-pattern` and the value is the regex pattern I want the check actual value test against. This specific example is checking an optional field which is accepting hours (0-23) of a day.

The expected behavior is that when any error happens I do not want to submit the form.

~~~javascript
  $('#mrs_form').submit(function(event) {
    var validator = new MeetingValidator('#mrs_form');

    if (!validator.checkValidity()) {
      event.preventDefault();
    }
  });
~~~

So far, so good.

Let's implement the validator:

~~~javascript
  function MeetingValidator(form_selector, options) {
    "use strict";
    var DEFAULT_OPTIONS = {
      on_finished : function() {}
    };
    options = $.extend({}, DEFAULT_OPTIONS, options);
    var issues = [];

    /**
     * @return false if there are validation errors
     */
    function checkValidity() {
      checkRegexPattern();
      options.on_finished(issues);
      return _.isEmpty(issues);
    }

    function checkRegexPattern() {
      $('[data-validation-pattern]', form_selector).each(function() {
        var name = $(this).attr('name');
        var patt = new RegExp($(this).data('validation-pattern'));
        var value = $(this).val();
        if (!patt.test(value)) {
          issues.push({
            kind : 'pattern',
            name : name,
            value : value
          });
        }
      });
    }
    MeetingValidator.prototype.checkValidity = checkValidity;
  }
~~~

Cool, isn't it? In function `checkRegexPattern` there are 4 effective lines of code which is dealing with all what I need.

You could say: "But it is not enough I need to report errors to the user". And I will say: "Yes, you are right!"

And here is the weakness of many validator plugins. They are not so flexible how to report the error. If you have a look at the code it has an optional input parameter called `options` with one relevant attribute called `on_finished` which is intended to be a function and called at the end of the validation process.

Let's see in practice:

~~~javascript
  $('#mrs_form').submit(function(event) {
    var validator = new MeetingValidator('#mrs_form', {
      on_finished : on_validation_finished
    });

    if (!validator.checkValidity()) {
      event.preventDefault();
    }
  });

  function on_validation_finished(issues) {
    _.each(issues, function(issue) {
      $('input[name="' + issue.name + '"]').parents('.form-group').addClass('has-error');
    });
  }
~~~

Function `on_validation_finished` is simply mark the field (using bootstrap styles).

Enjoy it!
