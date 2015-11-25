
package views.html.climate

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one or more		   *
 * contributor license agreements.  See the NOTICE file distributed with	   *
 * this work for additional information regarding copyright ownership.         *
 * The ASF licenses this file to You under the Apache License, Version 2.0     *
 * (the "License"); you may not use this file except in compliance with        *
 * the License.  You may obtain a copy of the License at                       *
 *                                                                             *
 *    http://www.apache.org/licenses/LICENSE-2.0                               *
 *																			   *
 * Unless required by applicable law or agreed to in writing, software         *
 * distributed under the License is distributed on an "AS IS" BASIS,           *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    *
 * See the License for the specific language governing permissions and         *
 * limitations under the License.											   *
 *******************************************************************************/
object aboutus extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,List[PostSet],play.data.Form[PostSet],play.api.templates.HtmlFormat.Appendable] {

    /*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one or more		   *
 * contributor license agreements.  See the NOTICE file distributed with	   *
 * this work for additional information regarding copyright ownership.         *
 * The ASF licenses this file to You under the Apache License, Version 2.0     *
 * (the "License"); you may not use this file except in compliance with        *
 * the License.  You may obtain a copy of the License at                       *
 *                                                                             *
 *    http://www.apache.org/licenses/LICENSE-2.0                               *
 *																			   *
 * Unless required by applicable law or agreed to in writing, software         *
 * distributed under the License is distributed on an "AS IS" BASIS,           *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    *
 * See the License for the specific language governing permissions and         *
 * limitations under the License.											   *
 *******************************************************************************/
    def apply/*18.2*/(message: String, postSets: List[PostSet], postSetForm: play.data.Form[PostSet]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*18.82*/("""
"""),format.raw/*20.1*/("""
<html class="st-layout ls-top-navbar ls-bottom-footer show-sidebar sidebar-l2" lang="en">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <meta name="description" content="">
 <meta name="author" content="">
 <title>Personal Page</title>

 <!-- Vendor CSS BUNDLE
   Includes styling for all of the 3rd party libraries used with this module, such as Bootstrap, Font Awesome and others.
   TIP: Using bundles will improve performance by reducing the number of network requests the client needs to make when loading the page. -->
 <link href='"""),_display_(Seq[Any](/*33.15*/routes/*33.21*/.Assets.at("css/vendor/all.css"))),format.raw/*33.53*/("""' rel="stylesheet">

 <!-- Vendor CSS Standalone Libraries
       NOTE: Some of these may have been customized (for example, Bootstrap).
       See: src/less/themes/"""),format.raw/*37.29*/("""{"""),format.raw/*37.30*/("""theme_name"""),format.raw/*37.40*/("""}"""),format.raw/*37.41*/("""/vendor/ directory -->
 <!-- <link href="css/vendor/bootstrap.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/font-awesome.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/picto.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/material-design-iconic-font.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/datepicker3.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/jquery.minicolors.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/bootstrap-slider.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/railscasts.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/jquery-jvectormap.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/owl.carousel.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/slick.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/morris.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/ui.fancytree.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/daterangepicker-bs3.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/jquery.bootstrap-touchspin.css" rel="stylesheet"> -->
 <!-- <link href="css/vendor/select2.css" rel="stylesheet"> -->

 <!-- APP CSS BUNDLE [css/app/app.css]
INCLUDES:
   - The APP CSS CORE styling required by the "social-2" module, also available with main.css - see below;
   - The APP CSS STANDALONE modules required by the "social-2" module;
NOTE:
   - This bundle may NOT include ALL of the available APP CSS STANDALONE modules;
     It was optimised to load only what is actually used by the "social-2" module;
     Other APP CSS STANDALONE modules may be available in addition to what's included with this bundle.
     See src/less/themes/social-2/app.less
TIP:
   - Using bundles will improve performance by greatly reducing the number of network requests the client needs to make when loading the page. -->
 <link href='"""),_display_(Seq[Any](/*66.15*/routes/*66.21*/.Assets.at("css/app/app.css"))),format.raw/*66.50*/("""' rel="stylesheet">

 <!-- App CSS CORE
This variant is to be used when loading the separate styling modules -->
 <!-- <link href="css/app/main.css" rel="stylesheet"> -->

 <!-- App CSS Standalone Modules
   As a convenience, we provide the entire UI framework broke down in separate modules
   Some of the standalone modules may have not been used with the current theme/module
   but ALL modules are 100% compatible -->

 <!-- <link href="css/app/essentials.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/layout.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/sidebar.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/sidebar-skins.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/navbar.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/media.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/player.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/timeline.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/cover.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/chat.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/charts.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/maps.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/colors-alerts.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/colors-background.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/colors-buttons.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/colors-calendar.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/colors-progress-bars.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/colors-text.css" rel="stylesheet" /> -->
 <!-- <link href="css/app/ui.css" rel="stylesheet" /> -->

 <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries
WARNING: Respond.js doesn't work if you view the page via file:// -->
 <!-- If you don't need support for Internet Explorer <= 8 you can safely remove these -->
 <!--[if lt IE 9]>
 <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
 <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
 <![endif]-->

</head>

<body>

<!-- Wrapper required for sidebar transitions -->
<div class="st-container">

 <!-- Fixed navbar -->
 <div class="navbar navbar-main navbar-primary navbar-fixed-top" role="navigation">
  <div class="container-fluid">
   <div class="navbar-header">
    <a href="#sidebar-menu" data-effect="st-effect-1" data-toggle="sidebar-menu" class="toggle pull-left visible-xs"><i class="fa fa-ellipsis-v"></i></a>
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-nav">
     <span class="sr-only">Toggle navigation</span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button>
    <a href="#sidebar-chat" data-toggle="sidebar-menu" data-effect="st-effect-1" class="toggle pull-right visible-xs"><i class="fa fa-comments"></i></a>
    <a class="navbar-brand" href="index.html">Social Network</a>
   </div>

   <!-- Collect the nav links, forms, and other content for toggling -->
   <div class="collapse navbar-collapse" id="main-nav">
    <ul class="nav navbar-nav">
     <!-- li><a href="../../../index.html">Themes</a></li -->
     <li class="dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <span class="caret"></span></a>
      <ul class="dropdown-menu" role="menu">
       <li class="dropdown-header">Public User Pages</li>
       <li><a href="index.html">Timeline</a></li>
       <li class="active"><a href="user-public-profile.html">About</a></li>
       <li><a href="user-public-users.html">Friends</a></li>
       <li class="dropdown-header">Private User Pages</li>
       <li><a href="user-private-messages.html">Messages</a></li>
       <li><a href="user-private-profile.html">Profile</a></li>
       <li><a href="user-private-timeline.html">Timeline</a></li>
       <li><a href="user-private-users.html">Friends</a></li>
      </ul>
     </li>
     <li><a href="essential-buttons.html">UI Components</a></li>
     <li class="hidden-sm" data-toggle="tooltip" data-placement="bottom" title="A few Color Examples. Download includes CSS Files for all color examples & the tools to Generate any Color combination. This Color-Switcher is for previewing purposes only.">
      <ul class="skins">

       <li><span data-file="app/app" data-skin="default" style="background: #16ae9f "></span></li>

       <li><span data-file="skin-orange" data-skin="orange" style="background: #e74c3c "></span></li>

       <li><span data-file="skin-blue" data-skin="blue" style="background: #4687ce "></span></li>

       <li><span data-file="skin-purple" data-skin="purple" style="background: #af86b9 "></span></li>

       <li><span data-file="skin-brown" data-skin="brown" style="background: #c3a961 "></span></li>

       <li><span data-file="skin-default-nav-inverse" data-skin="default-nav-inverse" style="background: #242424 "></span></li>

      </ul>
     </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li class="hidden-xs">
      <a href="#sidebar-chat" data-toggle="sidebar-menu" data-effect="st-effect-1">
       <i class="fa fa-comments"></i>
      </a>
     </li>
     <!-- User -->
     <li class="dropdown">
      <a href="#" class="dropdown-toggle user" data-toggle="dropdown">
       <img src='"""),_display_(Seq[Any](/*173.19*/routes/*173.25*/.Assets.at("images/people/110/guy-5.jpg"))),format.raw/*173.66*/("""' alt="Bill" class="img-circle" width="40" /> Bill <span class="caret"></span>
      </a>
      <ul class="dropdown-menu" role="menu">
       <li><a href="user-private-profile.html">Profile</a></li>
       <li><a href="user-private-messages.html">Messages</a></li>
       <li><a href="login.html">Logout</a></li>
      </ul>
     </li>
    </ul>
   </div>
   <!-- /.navbar-collapse -->

  </div>
 </div>

 <!-- Sidebar component with st-effect-1 (set on the toggle button within the navbar) -->
 <div class="sidebar left sidebar-size-2 sidebar-offset-0 sidebar-visible-desktop sidebar-visible-mobile sidebar-skin-dark" id="sidebar-menu">
  <div data-scrollable>
   <div class="sidebar-block">
    <div class="profile">
     <img src='"""),_display_(Seq[Any](/*193.17*/routes/*193.23*/.Assets.at("images/people/110/guy-5.jpg"))),format.raw/*193.64*/("""' alt="people" class="img-circle" />
     <h4>Bill</h4>
    </div>
   </div>
   <div class="category">About</div>
   <div class="sidebar-block">
    <ul class="list-about">
     <li><i class="fa fa-map-marker"></i> Amsterdam, NL</li>
     <li><i class="fa fa-link"></i> <a href="#">www.mosaicpro.biz</a></li>
     <li><i class="fa fa-twitter"></i> <a href="#">/mosaicprobiz</a></li>
    </ul>
   </div>
   <div class="category">Photos</div>
   <div class="sidebar-block">
    <div class="sidebar-photos">
     <ul>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*211.20*/routes/*211.26*/.Assets.at("images/place1.jpg"))),format.raw/*211.57*/("""' alt="people" />
       </a>
      </li>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*216.20*/routes/*216.26*/.Assets.at("images/place2.jpg"))),format.raw/*216.57*/("""' alt="people" />
       </a>
      </li>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*221.20*/routes/*221.26*/.Assets.at("images/place3.jpg"))),format.raw/*221.57*/("""' alt="people" />
       </a>
      </li>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*226.20*/routes/*226.26*/.Assets.at("images/food1.jpg"))),format.raw/*226.56*/("""' alt="people" />
       </a>
      </li>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*231.20*/routes/*231.26*/.Assets.at("images/food1.jpg"))),format.raw/*231.56*/("""' alt="people" />
       </a>
      </li>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*236.20*/routes/*236.26*/.Assets.at("images/place3.jpg"))),format.raw/*236.57*/("""' alt="people" />
       </a>
      </li>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*241.20*/routes/*241.26*/.Assets.at("images/place2.jpg"))),format.raw/*241.57*/("""' alt="people" />
       </a>
      </li>
      <li>
       <a href="#">
        <img src='"""),_display_(Seq[Any](/*246.20*/routes/*246.26*/.Assets.at("images/place1.jpg"))),format.raw/*246.57*/("""' alt="people" />
       </a>
      </li>
     </ul>
     <a href="#" class="btn btn-primary btn-xs">view all</a>
    </div>
   </div>
   <div class="category">Activity</div>
   <div class="sidebar-block">
    <ul class="sidebar-feed">
     <li class="media">
      <div class="media-left">
                <span class="media-object">
                            <i class="fa fa-fw fa-bell"></i>
                        </span>
      </div>
      <div class="media-body">
       <a href="" class="text-white">Adrian</a> just logged in
       <span class="time">2 min ago</span>
      </div>
      <div class="media-right">
       <span class="news-item-success"><i class="fa fa-circle"></i></span>
      </div>
     </li>
     <li class="media">

      <div class="media-left">
                <span class="media-object">
                            <i class="fa fa-fw fa-bell"></i>
                        </span>
      </div>
      <div class="media-body">
       <a href="" class="text-white">Adrian</a> just added <a href="" class="text-white">mosaicpro</a> as their office
       <span class="time">2 min ago</span>
      </div>
      <div class="media-right">
       <span class="news-item-success"><i class="fa fa-circle"></i></span>
      </div>
     </li>
     <li class="media">
      <div class="media-left">
                <span class="media-object">
                            <i class="fa fa-fw fa-bell"></i>
                        </span>
      </div>
      <div class="media-body">
       <a href="" class="text-white">Adrian</a> just logged in
       <span class="time">2 min ago</span>
      </div>
     </li>
     <li class="media">
      <div class="media-left">
                <span class="media-object">
                            <i class="fa fa-fw fa-bell"></i>
                        </span>
      </div>
      <div class="media-body">
       <a href="" class="text-white">Adrian</a> just logged in
       <span class="time">2 min ago</span>
      </div>
     </li>
     <li class="media">
      <div class="media-left">
                <span class="media-object">
                            <i class="fa fa-fw fa-bell"></i>
                        </span>
      </div>
      <div class="media-body">
       <a href="" class="text-white">Adrian</a> just logged in
       <span class="time">2 min ago</span>
      </div>
     </li>
    </ul>
   </div>
  </div>
 </div>

 <!-- Sidebar component with st-effect-1 (set on the toggle button within the navbar) -->
 <div class="sidebar sidebar-chat right sidebar-size-2 sidebar-offset-0 chat-skin-white" id=sidebar-chat>
  <div class="split-vertical">
   <div class="chat-search">
    <input type="text" class="form-control" placeholder="Search" />
   </div>

   <ul class="chat-filter nav nav-pills ">
    <li class="active"><a href="#" data-target="li">All</a></li>
    <li><a href="#" data-target=".online">Online</a></li>
    <li><a href="#" data-target=".offline">Offline</a></li>
   </ul>
   <div class="split-vertical-body">
    <div class="split-vertical-cell">
     <div data-scrollable>
      <ul class="chat-contacts">
       <li class="online" data-user-id="1">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*344.23*/routes/*344.29*/.Assets.at("images/people/110/guy-6.jpg"))),format.raw/*344.70*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">

           <div class="contact-name">Jonathan S.</div>
           <small>"Free Today"</small>
          </div>
         </div>
        </a>
       </li>

       <li class="online away" data-user-id="2">
        <a href="#">

         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*361.23*/routes/*361.29*/.Assets.at("images/people/110/woman-5.jpg"))),format.raw/*361.72*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Mary A.</div>
           <small>"Feeling Groovy"</small>
          </div>
         </div>
        </a>
       </li>
       <li class="online" data-user-id="3">
        <a href="#">
         <div class="media">
          <div class="pull-left ">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*375.23*/routes/*375.29*/.Assets.at("images/people/110/guy-3.jpg"))),format.raw/*375.70*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Adrian D.</div>
           <small>Busy</small>
          </div>
         </div>
        </a>
       </li>
       <li class="offline" data-user-id="4">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <img src='"""),_display_(Seq[Any](/*388.23*/routes/*388.29*/.Assets.at("images/people/110/woman-6.jpg"))),format.raw/*388.72*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Michelle S.</div>
           <small>Offline</small>
          </div>
         </div>
        </a>
       </li>
       <li class="offline" data-user-id="5">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <img src='"""),_display_(Seq[Any](/*401.23*/routes/*401.29*/.Assets.at("images/people/110/woman-7.jpg"))),format.raw/*401.72*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Daniele A.</div>
           <small>Offline</small>
          </div>
         </div>
        </a>
       </li>
       <li class="online" data-user-id="6">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*415.23*/routes/*415.29*/.Assets.at("images/people/110/guy-4.jpg"))),format.raw/*415.70*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Jake F.</div>
           <small>Busy</small>
          </div>
         </div>
        </a>
       </li>
       <li class="online away" data-user-id="7">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*429.23*/routes/*429.29*/.Assets.at("images/people/110/woman-6.jpg"))),format.raw/*429.72*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Jane A.</div>
           <small>"Custom Status"</small>
          </div>
         </div>
        </a>
       </li>
       <li class="offline" data-user-id="8">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*443.23*/routes/*443.29*/.Assets.at("images/people/110/woman-8.jpg"))),format.raw/*443.72*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Sabine J.</div>
           <small>"Offline right now"</small>
          </div>
         </div>
        </a>
       </li>
       <li class="online away" data-user-id="9">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*457.23*/routes/*457.29*/.Assets.at("images/people/110/woman-9.jpg"))),format.raw/*457.72*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Danny B.</div>
           <small>Be Right Back</small>
          </div>
         </div>
        </a>
       </li>
       <li class="online" data-user-id="10">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*471.23*/routes/*471.29*/.Assets.at("images/people/110/woman-8.jpg"))),format.raw/*471.72*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">Elise J.</div>
           <small>My Status</small>
          </div>
         </div>
        </a>
       </li>
       <li class="online" data-user-id="11">
        <a href="#">
         <div class="media">
          <div class="pull-left">
           <span class="status"></span>
           <img src='"""),_display_(Seq[Any](/*485.23*/routes/*485.29*/.Assets.at("images/people/110/guy-3.jpg"))),format.raw/*485.70*/("""' width="40" class="img-circle" />
          </div>
          <div class="media-body">
           <div class="contact-name">John J.</div>
           <small>My Status #1</small>
          </div>
         </div>
        </a>
       </li>
      </ul>
     </div>
    </div>
   </div>
  </div>
 </div>
 <script id="chat-window-template" type="text/x-handlebars-template">

  <div class="panel panel-default">
   <div class="panel-heading" data-toggle="chat-collapse" data-target="#chat-bill">
    <a href="#" class="close"><i class="fa fa-times"></i></a>
    <a href="#">
            <span class="pull-left">
                    <img src=""""),format.raw/*507.31*/("""{"""),format.raw/*507.32*/("""{"""),format.raw/*507.33*/(""" user_image """),format.raw/*507.45*/("""}"""),format.raw/*507.46*/("""}"""),format.raw/*507.47*/("""" width="40">
                </span>
     <span class="contact-name">"""),format.raw/*509.33*/("""{"""),format.raw/*509.34*/("""{"""),format.raw/*509.35*/("""user"""),format.raw/*509.39*/("""}"""),format.raw/*509.40*/("""}"""),format.raw/*509.41*/("""</span>
    </a>
   </div>
   <div class="panel-body" id="chat-bill">
    <div class="media">
     <div class="media-left">
      <img src=""""),format.raw/*515.17*/("""{"""),format.raw/*515.18*/("""{"""),format.raw/*515.19*/(""" user_image """),format.raw/*515.31*/("""}"""),format.raw/*515.32*/("""}"""),format.raw/*515.33*/("""" width="25" class="img-circle" alt="people" />
     </div>
     <div class="media-body">
      <span class="message">Feeling Groovy?</span>
     </div>
    </div>
    <div class="media">
     <div class="media-left">
      <img src=""""),format.raw/*523.17*/("""{"""),format.raw/*523.18*/("""{"""),format.raw/*523.19*/(""" user_image """),format.raw/*523.31*/("""}"""),format.raw/*523.32*/("""}"""),format.raw/*523.33*/("""" width="25" class="img-circle" alt="people" />
     </div>
     <div class="media-body">
      <span class="message">Yep.</span>
     </div>
    </div>
    <div class="media">
     <div class="media-left">
      <img src=""""),format.raw/*531.17*/("""{"""),format.raw/*531.18*/("""{"""),format.raw/*531.19*/(""" user_image """),format.raw/*531.31*/("""}"""),format.raw/*531.32*/("""}"""),format.raw/*531.33*/("""" width="25" class="img-circle" alt="people" />
     </div>
     <div class="media-body">
      <span class="message">This chat window looks amazing.</span>
     </div>
    </div>
    <div class="media">
     <div class="media-left">
      <img src=""""),format.raw/*539.17*/("""{"""),format.raw/*539.18*/("""{"""),format.raw/*539.19*/(""" user_image """),format.raw/*539.31*/("""}"""),format.raw/*539.32*/("""}"""),format.raw/*539.33*/("""" width="25" class="img-circle" alt="people" />
     </div>
     <div class="media-body">
      <span class="message">Thanks!</span>
     </div>
    </div>
   </div>
   <input type="text" class="form-control" placeholder="Type message..." />
  </div>
 </script>

 <div class="chat-window-container"></div>

 <!-- sidebar effects OUTSIDE of st-pusher: -->
 <!-- st-effect-1, st-effect-2, st-effect-4, st-effect-5, st-effect-9, st-effect-10, st-effect-11, st-effect-12, st-effect-13 -->

 <!-- content push wrapper -->
 <div class="st-pusher" id="content">

  <!-- sidebar effects INSIDE of st-pusher: -->
  <!-- st-effect-3, st-effect-6, st-effect-7, st-effect-8, st-effect-14 -->

  <!-- this is the wrapper for the content -->
  <div class="st-content">

   <!-- extra div for emulating position:fixed of the menu -->
   <div class="st-content-inner">

    <nav class="navbar navbar-subnav navbar-static-top margin-bottom-none" role="navigation">
     <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#subnav">
        <span class="sr-only">Toggle navigation</span>
        <span class="fa fa-ellipsis-h"></span>
       </button>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="subnav">
       <ul class="nav navbar-nav ">
        <li><a href=""""),_display_(Seq[Any](/*580.23*/routes/*580.29*/.HomePageController.homepage())),format.raw/*580.59*/(""""><i class="fa fa-fw icon-ship-wheel"></i> Public Page</a></li>
        <li class="active"><a href="user-public-profile.html"><i class="fa fa-fw icon-user-1"></i> Personal Page</a></li>
        <li><a href="user-public-users.html"><i class="fa fa-fw fa-users"></i> Friends</a></li>
       </ul>
       <ul class="nav navbar-nav hidden-xs navbar-right ">
        <li><a href="#" data-toggle="chat-box">Chat <i class="fa fa-fw fa-comment-o"></i></a></li>
       </ul>
      </div>
      <!-- /.navbar-collapse -->
     </div>

    </nav>
    <div class="cover overlay cover-image-full height-300-lg">

     <img src='"""),_display_(Seq[Any](/*594.17*/routes/*594.23*/.Assets.at("images/profile-cover.jpg"))),format.raw/*594.61*/("""' alt="cover" />
     <div class="overlay overlay-full">
      <div class="v-top">
       <a href="#" class="btn btn-cover"><i class="fa fa-pencil"></i></a>
      </div>
     </div>
    </div>

    <div class="container-fluid">

     """),_display_(Seq[Any](/*604.7*/helper/*604.13*/.form(action = routes.MainPageController.createNewPost)/*604.68*/ {_display_(Seq[Any](format.raw/*604.70*/("""
     <div class="container"
          style="background-image: url('"""),_display_(Seq[Any](/*606.42*/routes/*606.48*/.Assets.at("images/profile-cover1.jpg"))),format.raw/*606.87*/("""'); height: 30vh; background-size: 100%; ">
     <div
             class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
      <form class="form-signin">
       <h1 class="form-signin-heading" align="left">Create Posts</h1>
       <div class="form-group">
        <input type="postText" name="postText" id="postText" class="form-control"
               placeholder="Please type in a new post" required=""
               value='"""),_display_(Seq[Any](/*614.24*/postSetForm("postText")/*614.47*/.value)),format.raw/*614.53*/("""'>
       </div>
       <div class="form-group" id="msg1" style="color: red;"></div>
       <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
         <div class="form-group">
          <input type="postStatus" name="postStatus" id="postStatus"
                 class="form-control" placeholder="0 for Public / 1 for Private" required=""
                 value='"""),_display_(Seq[Any](/*622.26*/postSetForm("postStatus")/*622.51*/.value)),format.raw/*622.57*/("""'>
         </div>
        </div>
       </div>
       <div class="actions row">
        <div class="col-xs-12 col-sm-6 col-md-6">
         <input type="submit" class="btn btn-primary btn-block"
                value="Add" id="add">
        </div>
       </div>
      </form>
     </div>
    </div>
    """)))})),format.raw/*635.6*/("""

    <div>
     <h1>Personal Posts</h1>
     """),_display_(Seq[Any](/*639.7*/for(postSet <- postSets) yield /*639.31*/{_display_(Seq[Any](format.raw/*639.32*/("""
     <h3><font size="=1">Post</font> </h3>
     <td><span class=""""),_display_(Seq[Any](/*641.24*/postSet/*641.31*/.getPostId())),format.raw/*641.43*/(""" editable" data-name='text'>
				"""),_display_(Seq[Any](/*642.6*/postSet/*642.13*/.getPostText())),format.raw/*642.27*/(""" </span></td><br>
     <td><font size="2">Post Status: """),_display_(Seq[Any](/*643.39*/postSet/*643.46*/.getPostStatus())),format.raw/*643.62*/("""</font></td>
     <br>
     <td><font size="2">Post Time: """),_display_(Seq[Any](/*645.37*/postSet/*645.44*/.getPostTime())),format.raw/*645.58*/("""</font></td>
     <br>
     <td class="operation">
      <input type="button" class="edit-btn btn btn-primary" value="Edit"
             data-pk='"""),_display_(Seq[Any](/*649.24*/postSet/*649.31*/.getPostId())),format.raw/*649.43*/("""'
             data-url='"""),_display_(Seq[Any](/*650.25*/routes/*650.31*/.MainPageController.editPost())),format.raw/*650.61*/("""'
      >
     </td>
     """),_display_(Seq[Any](/*653.7*/form(routes.MainPageController.deletePost)/*653.49*/{_display_(Seq[Any](format.raw/*653.50*/("""
     <input
             name="idHolder" class="hidden" type="hidden"
             value=""""),_display_(Seq[Any](/*656.22*/postSet/*656.29*/.getPostId())),format.raw/*656.41*/("""">
     <input
             type="submit" class="btn btn-danger delete-btn span2" value="Delete"
             onclick="return confirm('Are you sure you want to delete this post?')">
     """)))})),format.raw/*660.7*/("""
     """)))})),format.raw/*661.7*/("""
    </div>

     <div class="panel panel-default share">
      <div class="input-group">
       <div class="input-group-btn">
        <a class="btn btn-primary" href="#"><i class="fa fa-envelope"></i> Send</a>
       </div>
       <!-- /btn-group -->
       <input type="text" class="form-control share-text" placeholder="Write message..." />
      </div>
      <!-- /input-group -->
     </div>

     <div class="tabbable">
      <ul class="nav nav-tabs">
       <li class="active"><a href="#home" data-toggle="tab"><i class="fa fa-fw fa-picture-o"></i> Photos</a></li>
       <li class=""><a href="#profile" data-toggle="tab"><i class="fa fa-fw fa-folder"></i> Albums</a></li>
      </ul>
      <div class="tab-content">
       <div class="tab-pane fade active in" id="home">
        <img src='"""),_display_(Seq[Any](/*682.20*/routes/*682.26*/.Assets.at("images/place1.jpg"))),format.raw/*682.57*/("""' alt="image" />
        <img src='"""),_display_(Seq[Any](/*683.20*/routes/*683.26*/.Assets.at("images/place2.jpg"))),format.raw/*683.57*/("""' alt="image" />
        <img src='"""),_display_(Seq[Any](/*684.20*/routes/*684.26*/.Assets.at("images/food1.jpg"))),format.raw/*684.56*/("""' alt="image" />
       </div>
       <div class="tab-pane fade" id="profile">
        <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth
         letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown.
         Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
       </div>
       <div class="tab-pane fade" id="dropdown1">
        <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy
         salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably
         haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
       </div>
       <div class="tab-pane fade" id="dropdown2">
        <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo
         park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial
         keffiyeh echo park vegan.</p>
       </div>
      </div>
     </div>
     <div class="row">
      <div class="col-md-6">
       <div class="panel panel-default">
        <div class="panel-heading panel-heading-gray">
         <a href="#" class="btn btn-white btn-xs pull-right"><i class="fa fa-pencil"></i></a>
         <i class="fa fa-fw fa-info-circle"></i> About
        </div>
        <div class="panel-body">
         <ul class="list-unstyled profile-about margin-none">
          <li class="padding-v-5">
           <div class="row">
            <div class="col-sm-4"><span class="text-muted">Date of Birth</span></div>
            <div class="col-sm-8">12 January 1990</div>
           </div>
          </li>
          <li class="padding-v-5">
           <div class="row">
            <div class="col-sm-4"><span class="text-muted">Job</span></div>
            <div class="col-sm-8">Specialist</div>
           </div>
          </li>
          <li class="padding-v-5">
           <div class="row">
            <div class="col-sm-4"><span class="text-muted">Gender</span></div>
            <div class="col-sm-8">Male</div>
           </div>
          </li>
          <li class="padding-v-5">
           <div class="row">
            <div class="col-sm-4"><span class="text-muted">Lives in</span></div>
            <div class="col-sm-8">Miami, FL, USA</div>
           </div>
          </li>
          <li class="padding-v-5">
           <div class="row">
            <div class="col-sm-4"><span class="text-muted">Credits</span></div>
            <div class="col-sm-8">249</div>
           </div>
          </li>
         </ul>
        </div>
       </div>
      </div>
      <div class="col-md-6">
       <div class="panel panel-default">
        <div class="panel-heading panel-heading-gray">
         <div class="pull-right">
          <a href="#" class="btn btn-primary btn-xs">Add <i class="fa fa-plus"></i></a>
         </div>
         <i class="icon-user-1"></i> Friends
        </div>
        <div class="panel-body">
         <ul class="img-grid">
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*758.24*/routes/*758.30*/.Assets.at("images/people/110/guy-1.jpg"))),format.raw/*758.71*/("""' alt="image" />
           </a>
          </li>
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*763.24*/routes/*763.30*/.Assets.at("images/people/110/woman-1.jpg"))),format.raw/*763.73*/("""' alt="image" />
           </a>
          </li>
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*768.24*/routes/*768.30*/.Assets.at("images/people/110/guy-2.jpg"))),format.raw/*768.71*/("""' alt="image" />
           </a>
          </li>
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*773.24*/routes/*773.30*/.Assets.at("images/people/110/guy-3.jpg"))),format.raw/*773.71*/("""' alt="image" />
           </a>
          </li>
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*778.24*/routes/*778.30*/.Assets.at("images/people/110/woman-2.jpg"))),format.raw/*778.73*/("""' alt="image" />
           </a>
          </li>
          <li class="clearfix">
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*783.24*/routes/*783.30*/.Assets.at("images/people/110/guy-4.jpg"))),format.raw/*783.71*/("""' alt="image" />
           </a>
          </li>
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*788.24*/routes/*788.30*/.Assets.at("images/people/110/guy-6.jpg"))),format.raw/*788.71*/("""' alt="image" />
           </a>
          </li>
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*793.24*/routes/*793.30*/.Assets.at("images/people/110/woman-3.jpg"))),format.raw/*793.73*/("""' alt="image" />
           </a>
          </li>
          <li>
           <a href="#">
            <img src='"""),_display_(Seq[Any](/*798.24*/routes/*798.30*/.Assets.at("images/people/110/guy-7.jpg"))),format.raw/*798.71*/("""' alt="image" />
           </a>
          </li>
         </ul>
        </div>
       </div>
      </div>
     </div>


    </div>

   </div>
   <!-- /st-content-inner -->

  </div>
  <!-- /st-content -->

 </div>
 <!-- /st-pusher -->

 <!-- Footer -->
 <footer class="footer">
  <strong>SOC Team 12</strong>
 </footer>
 <!-- // Footer -->

</div>
<!-- /st-container -->

<!-- Inline Script for colors and config objects; used by various external scripts; -->
<script>
 var colors = """),format.raw/*830.15*/("""{"""),format.raw/*830.16*/("""
  "danger-color": "#e74c3c",
  "success-color": "#81b53e",
  "warning-color": "#f0ad4e",
  "inverse-color": "#2c3e50",
  "info-color": "#2d7cb5",
  "default-color": "#6e7882",
  "default-light-color": "#cfd9db",
  "purple-color": "#9D8AC7",
  "mustard-color": "#d4d171",
  "lightred-color": "#e15258",
  "body-bg": "#f6f6f6"
 """),format.raw/*842.2*/("""}"""),format.raw/*842.3*/(""";
 var config = """),format.raw/*843.15*/("""{"""),format.raw/*843.16*/("""
  theme: "social-2",
  skins: """),format.raw/*845.10*/("""{"""),format.raw/*845.11*/("""
   "default": """),format.raw/*846.15*/("""{"""),format.raw/*846.16*/("""
    "primary-color": "#16ae9f"
   """),format.raw/*848.4*/("""}"""),format.raw/*848.5*/(""",
   "orange": """),format.raw/*849.14*/("""{"""),format.raw/*849.15*/("""
    "primary-color": "#e74c3c"
   """),format.raw/*851.4*/("""}"""),format.raw/*851.5*/(""",
   "blue": """),format.raw/*852.12*/("""{"""),format.raw/*852.13*/("""
    "primary-color": "#4687ce"
   """),format.raw/*854.4*/("""}"""),format.raw/*854.5*/(""",
   "purple": """),format.raw/*855.14*/("""{"""),format.raw/*855.15*/("""
    "primary-color": "#af86b9"
   """),format.raw/*857.4*/("""}"""),format.raw/*857.5*/(""",
   "brown": """),format.raw/*858.13*/("""{"""),format.raw/*858.14*/("""
    "primary-color": "#c3a961"
   """),format.raw/*860.4*/("""}"""),format.raw/*860.5*/(""",
   "default-nav-inverse": """),format.raw/*861.27*/("""{"""),format.raw/*861.28*/("""
    "color-block": "#242424"
   """),format.raw/*863.4*/("""}"""),format.raw/*863.5*/("""
  """),format.raw/*864.3*/("""}"""),format.raw/*864.4*/("""
 """),format.raw/*865.2*/("""}"""),format.raw/*865.3*/(""";
</script>

<!-- Vendor Scripts Bundle
  Includes all of the 3rd party JavaScript libraries above.
  The bundle was generated using modern frontend development tools that are provided with the package
  To learn more about the development process, please refer to the documentation.
  Do not use it simultaneously with the separate bundles above. -->
<script src="js/vendor/all.js"></script>

<!-- Vendor Scripts Standalone Libraries -->
<!-- <script src="js/vendor/core/all.js"></script> -->
<!-- <script src="js/vendor/core/jquery.js"></script> -->
<!-- <script src="js/vendor/core/bootstrap.js"></script> -->
<!-- <script src="js/vendor/core/breakpoints.js"></script> -->
<!-- <script src="js/vendor/core/jquery.nicescroll.js"></script> -->
<!-- <script src="js/vendor/core/isotope.pkgd.js"></script> -->
<!-- <script src="js/vendor/core/packery-mode.pkgd.js"></script> -->
<!-- <script src="js/vendor/core/jquery.grid-a-licious.js"></script> -->
<!-- <script src="js/vendor/core/jquery.cookie.js"></script> -->
<!-- <script src="js/vendor/core/jquery-ui.custom.js"></script> -->
<!-- <script src="js/vendor/core/jquery.hotkeys.js"></script> -->
<!-- <script src="js/vendor/core/handlebars.js"></script> -->
<!-- <script src="js/vendor/core/jquery.hotkeys.js"></script> -->
<!-- <script src="js/vendor/core/load_image.js"></script> -->
<!-- <script src="js/vendor/core/jquery.debouncedresize.js"></script> -->
<!-- <script src="js/vendor/tables/all.js"></script> -->
<!-- <script src="js/vendor/forms/all.js"></script> -->
<!-- <script src="js/vendor/media/all.js"></script> -->
<!-- <script src="js/vendor/player/all.js"></script> -->
<!-- <script src="js/vendor/charts/all.js"></script> -->
<!-- <script src="js/vendor/charts/flot/all.js"></script> -->
<!-- <script src="js/vendor/charts/easy-pie/jquery.easypiechart.js"></script> -->
<!-- <script src="js/vendor/charts/morris/all.js"></script> -->
<!-- <script src="js/vendor/charts/sparkline/all.js"></script> -->
<!-- <script src="js/vendor/maps/vector/all.js"></script> -->
<!-- <script src="js/vendor/tree/jquery.fancytree-all.js"></script> -->
<!-- <script src="js/vendor/nestable/jquery.nestable.js"></script> -->
<!-- <script src="js/vendor/angular/all.js"></script> -->

<!-- App Scripts Bundle
  Includes Custom Application JavaScript used for the current theme/module;
  Do not use it simultaneously with the standalone modules below. -->
<script src="js/app/app.js"></script>

<!-- App Scripts Standalone Modules
  As a convenience, we provide the entire UI framework broke down in separate modules
  Some of the standalone modules may have not been used with the current theme/module
  but ALL the modules are 100% compatible -->

<!-- <script src="js/app/essentials.js"></script> -->
<!-- <script src="js/app/layout.js"></script> -->
<!-- <script src="js/app/sidebar.js"></script> -->
<!-- <script src="js/app/media.js"></script> -->
<!-- <script src="js/app/player.js"></script> -->
<!-- <script src="js/app/timeline.js"></script> -->
<!-- <script src="js/app/chat.js"></script> -->
<!-- <script src="js/app/maps.js"></script> -->
<!-- <script src="js/app/charts/all.js"></script> -->
<!-- <script src="js/app/charts/flot.js"></script> -->
<!-- <script src="js/app/charts/easy-pie.js"></script> -->
<!-- <script src="js/app/charts/morris.js"></script> -->
<!-- <script src="js/app/charts/sparkline.js"></script> -->

<!-- App Scripts CORE [social-2]:
      Includes the custom JavaScript for this theme/module;
      The file has to be loaded in addition to the UI modules above;
      app.js already includes main.js so this should be loaded
      ONLY when using the standalone modules; -->
<!-- <script src="js/app/main.js"></script> -->

</body>
</html>"""))}
    }
    
    def render(message:String,postSets:List[PostSet],postSetForm:play.data.Form[PostSet]): play.api.templates.HtmlFormat.Appendable = apply(message,postSets,postSetForm)
    
    def f:((String,List[PostSet],play.data.Form[PostSet]) => play.api.templates.HtmlFormat.Appendable) = (message,postSets,postSetForm) => apply(message,postSets,postSetForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 24 17:25:10 PST 2015
                    SOURCE: /Users/K/SOC-Fall-2015-Team12/ApacheCMDA-Frontend/app/views/climate/aboutus.scala.html
                    HASH: b9141b26c7a51f86946911a9e3275c149b7bff7b
                    MATRIX: 3217->1205|3408->1285|3436->1303|4123->1954|4138->1960|4192->1992|4385->2157|4414->2158|4452->2168|4481->2169|6375->4027|6390->4033|6441->4062|11848->9432|11864->9438|11928->9479|12700->10214|12716->10220|12780->10261|13382->10826|13398->10832|13452->10863|13581->10955|13597->10961|13651->10992|13780->11084|13796->11090|13850->11121|13979->11213|13995->11219|14048->11249|14177->11341|14193->11347|14246->11377|14375->11469|14391->11475|14445->11506|14574->11598|14590->11604|14644->11635|14773->11727|14789->11733|14843->11764|18176->15060|18192->15066|18256->15107|18731->15545|18747->15551|18813->15594|19281->16025|19297->16031|19361->16072|19779->16453|19795->16459|19861->16502|20284->16888|20300->16894|20366->16937|20827->17361|20843->17367|20907->17408|21367->17831|21383->17837|21449->17880|21916->18310|21932->18316|21998->18359|22475->18799|22491->18805|22557->18848|23023->19277|23039->19283|23105->19326|23567->19751|23583->19757|23647->19798|24311->20433|24341->20434|24371->20435|24412->20447|24442->20448|24472->20449|24571->20519|24601->20520|24631->20521|24664->20525|24694->20526|24724->20527|24893->20667|24923->20668|24953->20669|24994->20681|25024->20682|25054->20683|25317->20917|25347->20918|25377->20919|25418->20931|25448->20932|25478->20933|25730->21156|25760->21157|25790->21158|25831->21170|25861->21171|25891->21172|26170->21422|26200->21423|26230->21424|26271->21436|26301->21437|26331->21438|27886->22956|27902->22962|27955->22992|28608->23608|28624->23614|28685->23652|28956->23887|28972->23893|29037->23948|29078->23950|29185->24020|29201->24026|29263->24065|29743->24508|29776->24531|29805->24537|30223->24918|30258->24943|30287->24949|30623->25253|30706->25300|30747->25324|30787->25325|30891->25392|30908->25399|30943->25411|31013->25445|31030->25452|31067->25466|31160->25522|31177->25529|31216->25545|31312->25604|31329->25611|31366->25625|31550->25772|31567->25779|31602->25791|31665->25817|31681->25823|31734->25853|31797->25880|31849->25922|31889->25923|32018->26015|32035->26022|32070->26034|32290->26222|32329->26229|33164->27027|33180->27033|33234->27064|33307->27100|33323->27106|33377->27137|33450->27173|33466->27179|33519->27209|37742->31395|37758->31401|37822->31442|37970->31553|37986->31559|38052->31602|38200->31713|38216->31719|38280->31760|38428->31871|38444->31877|38508->31918|38656->32029|38672->32035|38738->32078|38903->32206|38919->32212|38983->32253|39131->32364|39147->32370|39211->32411|39359->32522|39375->32528|39441->32571|39589->32682|39605->32688|39669->32729|40181->33212|40211->33213|40566->33540|40595->33541|40640->33557|40670->33558|40730->33589|40760->33590|40804->33605|40834->33606|40897->33641|40926->33642|40970->33657|41000->33658|41063->33693|41092->33694|41134->33707|41164->33708|41227->33743|41256->33744|41300->33759|41330->33760|41393->33795|41422->33796|41465->33810|41495->33811|41558->33846|41587->33847|41644->33875|41674->33876|41735->33909|41764->33910|41795->33913|41824->33914|41854->33916|41883->33917
                    LINES: 56->18|60->18|61->20|74->33|74->33|74->33|78->37|78->37|78->37|78->37|107->66|107->66|107->66|214->173|214->173|214->173|234->193|234->193|234->193|252->211|252->211|252->211|257->216|257->216|257->216|262->221|262->221|262->221|267->226|267->226|267->226|272->231|272->231|272->231|277->236|277->236|277->236|282->241|282->241|282->241|287->246|287->246|287->246|385->344|385->344|385->344|402->361|402->361|402->361|416->375|416->375|416->375|429->388|429->388|429->388|442->401|442->401|442->401|456->415|456->415|456->415|470->429|470->429|470->429|484->443|484->443|484->443|498->457|498->457|498->457|512->471|512->471|512->471|526->485|526->485|526->485|548->507|548->507|548->507|548->507|548->507|548->507|550->509|550->509|550->509|550->509|550->509|550->509|556->515|556->515|556->515|556->515|556->515|556->515|564->523|564->523|564->523|564->523|564->523|564->523|572->531|572->531|572->531|572->531|572->531|572->531|580->539|580->539|580->539|580->539|580->539|580->539|621->580|621->580|621->580|635->594|635->594|635->594|645->604|645->604|645->604|645->604|647->606|647->606|647->606|655->614|655->614|655->614|663->622|663->622|663->622|676->635|680->639|680->639|680->639|682->641|682->641|682->641|683->642|683->642|683->642|684->643|684->643|684->643|686->645|686->645|686->645|690->649|690->649|690->649|691->650|691->650|691->650|694->653|694->653|694->653|697->656|697->656|697->656|701->660|702->661|723->682|723->682|723->682|724->683|724->683|724->683|725->684|725->684|725->684|799->758|799->758|799->758|804->763|804->763|804->763|809->768|809->768|809->768|814->773|814->773|814->773|819->778|819->778|819->778|824->783|824->783|824->783|829->788|829->788|829->788|834->793|834->793|834->793|839->798|839->798|839->798|871->830|871->830|883->842|883->842|884->843|884->843|886->845|886->845|887->846|887->846|889->848|889->848|890->849|890->849|892->851|892->851|893->852|893->852|895->854|895->854|896->855|896->855|898->857|898->857|899->858|899->858|901->860|901->860|902->861|902->861|904->863|904->863|905->864|905->864|906->865|906->865
                    -- GENERATED --
                */
            