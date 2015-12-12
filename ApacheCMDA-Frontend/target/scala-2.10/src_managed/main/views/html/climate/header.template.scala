
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
object header extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*18.4*/("""
<body>
	<div class="navbar navbar-main navbar-primary navbar-fixed-top" role="navigation">

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
		<div class="navbar-collapse collapse" style="height:">
			<ul class="nav navbar-nav navbar-right">
					<!--<h3 class="pull-left" >Social Network&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h3>-->
				<li><a href=""""),_display_(Seq[Any](/*38.19*/routes/*38.25*/.HomePageController.homepage())),format.raw/*38.55*/("""">Public Page</a></li>
				<li><a href=""""),_display_(Seq[Any](/*39.19*/routes/*39.25*/.MainPageController.mainpage())),format.raw/*39.55*/("""">Private Page</a></li>

				<li class="dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown">About<b
				class="caret"></b></a>
					<ul class="dropdown-menu">
							<!--<li><a href=""""),_display_(Seq[Any](/*45.26*/routes/*45.32*/.ClimateServiceController.home())),format.raw/*45.64*/("""">Home</a></li>-->
						<li><a href=""""),_display_(Seq[Any](/*46.21*/routes/*46.27*/.AboutusController.aboutUs())),format.raw/*46.55*/("""">About Us</a></li>
					<!--<li><a href=""""),_display_(Seq[Any](/*47.24*/routes/*47.30*/.AboutusController.aboutProject())),format.raw/*47.63*/("""">About project</a></li>-->
					</ul>
				</li>

				<!--<li class="dropdown"><a href="#"-->
				<!--class="dropdown-toggle" data-toggle="dropdown">Profile<b-->
				<!--class="caret"></b></a>-->
				<!--<ul class="dropdown-menu">-->
				<!--&lt;!&ndash;<li><a href=""""),_display_(Seq[Any](/*55.35*/routes/*55.41*/.MainPageController.mainpage())),format.raw/*55.71*/("""">Main Page</a></li>&ndash;&gt;-->
			<!--<li><a href=""""),_display_(Seq[Any](/*56.22*/routes/*56.28*/.AboutusController.aboutUs())),format.raw/*56.56*/("""">Log out</a></li>-->
			<!--</ul>-->
			<!--</li>-->

			"""),_display_(Seq[Any](/*60.5*/if(!session.get("email"))/*60.30*/ {_display_(Seq[Any](format.raw/*60.32*/("""
				<form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*61.53*/routes/*61.59*/.Application.login())),format.raw/*61.79*/("""">
					<button type="submit" class="btn btn-success">Log in</button>
				</form>
			""")))}/*64.6*/else/*64.11*/{_display_(Seq[Any](format.raw/*64.12*/("""
					<!--<li class="dropdown">-->
					<!--<a href="#" class="dropdown-toggle" data-toggle="dropdown">My Services<b class="caret"></b></a>-->
					<!--<ul class="dropdown-menu">-->
					<!--<li><a href="#">My climate services</a></li>-->
					<!--<li><a href="#">My datasets</a></li>-->
					<!--</ul>-->
					<!--</li>-->

				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome. """),_display_(Seq[Any](/*74.75*/session/*74.82*/.get("userName"))),format.raw/*74.98*/("""<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href=""""),_display_(Seq[Any](/*76.21*/routes/*76.27*/.Application.logout())),format.raw/*76.48*/("""">Log out</a></li>
					</ul>
				</li>
			""")))})),format.raw/*79.5*/("""

			"""),_display_(Seq[Any](/*81.5*/if(false)/*81.14*/ {_display_(Seq[Any](format.raw/*81.16*/("""
				<form class="navbar-form navbar-right" action="#">
					<button type="submit" class="btn btn-success">Admin Console</button>
				</form>
			""")))})),format.raw/*85.5*/("""

			</ul>
		</div>
			<!--/.nav-collapse -->
	</div>
</body>
<!-- /.navbar-collapse -->"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 14:49:59 PST 2015
                    SOURCE: /Users/K/SOC-Team12-Final-Version/SOC-ApacheCMDA-Frontend/app/views/climate/header.scala.html
                    HASH: fb464770f1fe849c7d3175e19da31447dbf84624
                    MATRIX: 3171->1204|3267->1206|4376->2279|4391->2285|4443->2315|4520->2356|4535->2362|4587->2392|4828->2597|4843->2603|4897->2635|4972->2674|4987->2680|5037->2708|5116->2751|5131->2757|5186->2790|5490->3058|5505->3064|5557->3094|5649->3150|5664->3156|5714->3184|5808->3243|5842->3268|5882->3270|5971->3323|5986->3329|6028->3349|6132->3436|6145->3441|6184->3442|6645->3867|6661->3874|6699->3890|6813->3968|6828->3974|6871->3995|6946->4039|6987->4045|7005->4054|7045->4056|7222->4202
                    LINES: 56->18|59->18|79->38|79->38|79->38|80->39|80->39|80->39|86->45|86->45|86->45|87->46|87->46|87->46|88->47|88->47|88->47|96->55|96->55|96->55|97->56|97->56|97->56|101->60|101->60|101->60|102->61|102->61|102->61|105->64|105->64|105->64|115->74|115->74|115->74|117->76|117->76|117->76|120->79|122->81|122->81|122->81|126->85
                    -- GENERATED --
                */
            