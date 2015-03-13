grails-spring-security-twitter-oauth-example
============================================
An example application to demonstrate Spring Security Twitter OAuth.

Requires Grails 2.4.0, Spring Security Core 2.0-RC3, Spring Security 
Core OAuth 2.0.2, Spring Security Core OAuth Twitter 0.1.

Get Started
-----------
1. Setup your Twitter App on Twitter.com.
2. Edit `Config.groovy` and add the settings
as shown below with the right values for your environment:
```
oauth {
  providers {
    twitter {
      api = org.scribe.builder.api.TwitterApi.SSL
      key = '<twitter_oauth_key>'
      secret = '<twitter_oauth_secret>'
      successUri = '/oauth/twitter/success'
      failureUri = '/oauth/twitter/error'
      callback = 'http://localhost:8080/oauthapp/oauth/twitter/callback'
    }
  }
  debug = true
}

```

3. then run the application:

```
$ grails run-app
```

Troubleshooting
-----
You must make sure you have set up a developer account with Twitter and created an Application.
    *Create an account at [Twitter's Dev page](https://dev.twitter.com/)
    *Once you have an account, navigate to the [Twitter App page](https://apps.twitter.com/)
    *Here you will create a new app. Name the app something similar to grailsTwitterTest.
    *Most of the fields are pretty straightforward. However, pay special attention to the Callback URL.
    You will not need a real URL but http://localhost:8080 does not seem to work. Simply use something like, http://grailsTwitterTest//oauthapp/oauth/twitter/callback
    *If you have already created an application or got started before reading this section, you can make changes to the application
    you registered by going to the apps.twitter url for your application. It looks similar to: https://apps.twitter.com/app/9999999(application number)/settings

Links
-----
  * Spring Security Core http://grails.org/plugin/spring-security-core
  * Spring Security OAuth http://grails.org/plugin/spring-security-oauth
  * Spring Security OAuth Twitter http://grails.org/plugin/spring-security-oauth-twitter


What to watch out for when building your own app?
-------------------------------------------------
1. By default, Spring Security Core shuts down access to all URL's. I had to
   open up SpringSecurityOAuthController.groovy and OauthController.groovy to
   get them to work.

2. Twitter now requires SSL when requesting an Auth Token.

3. The generic template generated SpringSecurityController.groovy attempts to
   compare password hashes. That was changed. 
   https://github.com/cazacugmihai/grails-spring-security-oauth/issues/6#issuecomment-38184458


Reach me
--------
[Santosh Dawara](http://www.santoshdawara.com)
