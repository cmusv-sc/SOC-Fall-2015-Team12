
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
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="padding-bottom: 0;" href="/climate"><img
					src='"""),_display_(Seq[Any](/*29.12*/routes/*29.18*/.Assets.at("images/NASA_JPL_logo.png"))),format.raw/*29.56*/("""' style="height: 40px; width: 220px;">&nbsp&nbsp<img
					src='"""),_display_(Seq[Any](/*30.12*/routes/*30.18*/.Assets.at("images/logo.png"))),format.raw/*30.47*/("""' style="height: 15px; width: 250px;"></a>
			</div>
			<div class="navbar-collapse collapse" style="height:">
				<ul class="nav navbar-nav navbar-right">
					
					<li><a href=""""),_display_(Seq[Any](/*35.20*/routes/*35.26*/.HomePageController.homepage())),format.raw/*35.56*/("""">Home Page</a></li>

					<li class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Dataset<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
						
						<li><a href=""""),_display_(Seq[Any](/*42.21*/routes/*42.27*/.DatasetController.datasetList())),format.raw/*42.59*/("""">Dataset List</a></li>
						<li><a href=""""),_display_(Seq[Any](/*43.21*/routes/*43.27*/.DatasetController.searchDataset())),format.raw/*43.61*/("""">Search dataset</a></li>
						</ul>
					</li>
					"""),format.raw/*46.42*/("""
						"""),format.raw/*47.67*/("""
							"""),format.raw/*48.34*/("""
						"""),format.raw/*49.37*/("""
							"""),format.raw/*50.101*/("""
							"""),format.raw/*51.106*/("""
						"""),format.raw/*52.16*/("""
					"""),format.raw/*53.15*/("""
					
					<li class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">About<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
						<li><a href=""""),_display_(Seq[Any](/*59.21*/routes/*59.27*/.ClimateServiceController.home())),format.raw/*59.59*/("""">Home</a></li>
						<li><a href=""""),_display_(Seq[Any](/*60.21*/routes/*60.27*/.AboutusController.aboutUs())),format.raw/*60.55*/("""">About Us</a></li>
						<li><a href=""""),_display_(Seq[Any](/*61.21*/routes/*61.27*/.AboutusController.aboutProject())),format.raw/*61.60*/("""">About project</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="#"
											class="dropdown-toggle" data-toggle="dropdown">Profile<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href=""""),_display_(Seq[Any](/*69.22*/routes/*69.28*/.MainPageController.mainpage())),format.raw/*69.58*/("""">Main Page</a></li>
							<li><a href=""""),_display_(Seq[Any](/*70.22*/routes/*70.28*/.AboutusController.aboutUs())),format.raw/*70.56*/("""">Log out</a></li>
						</ul>
					</li>
					
					"""),_display_(Seq[Any](/*74.7*/if(!session.get("email"))/*74.32*/ {_display_(Seq[Any](format.raw/*74.34*/("""
						<form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*75.55*/routes/*75.61*/.Application.login())),format.raw/*75.81*/("""">
							<button type="submit" class="btn btn-success">Log in</button>
						</form>
					""")))}/*78.8*/else/*78.13*/{_display_(Seq[Any](format.raw/*78.14*/("""
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">My Services<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">My climate services</a></li>
								<li><a href="#">My datasets</a></li>
							</ul>
						</li>
						
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*88.68*/session/*88.75*/.get("email"))),format.raw/*88.88*/("""<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href=""""),_display_(Seq[Any](/*90.23*/routes/*90.29*/.Application.logout())),format.raw/*90.50*/("""">Log out</a></li>
							</ul>
						</li>
					""")))})),format.raw/*93.7*/("""	
										
					"""),_display_(Seq[Any](/*95.7*/if(false)/*95.16*/ {_display_(Seq[Any](format.raw/*95.18*/("""
						<form class="navbar-form navbar-right" action="#">
							<button type="submit" class="btn btn-success">Admin Console</button>
						</form>
					""")))})),format.raw/*99.7*/("""
					
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Nov 20 11:55:18 PST 2015
                    SOURCE: /Users/K/SOC-Fall-2015-Team12/ApacheCMDA-Frontend/app/views/climate/header.scala.html
                    HASH: 06fe06442e7aaf1e23f06e0b3e805c6fa8462d75
                    MATRIX: 3171->1205|3267->1207|3799->1703|3814->1709|3874->1747|3974->1811|3989->1817|4040->1846|4257->2027|4272->2033|4324->2063|4573->2276|4588->2282|4642->2314|4722->2358|4737->2364|4793->2398|4875->2488|4910->2555|4946->2589|4981->2626|5018->2727|5055->2833|5090->2849|5124->2864|5349->3053|5364->3059|5418->3091|5490->3127|5505->3133|5555->3161|5631->3201|5646->3207|5701->3240|5976->3479|5991->3485|6043->3515|6121->3557|6136->3563|6186->3591|6275->3645|6309->3670|6349->3672|6440->3727|6455->3733|6497->3753|6607->3846|6620->3851|6659->3852|7086->4243|7102->4250|7137->4263|7255->4345|7270->4351|7313->4372|7394->4422|7448->4441|7466->4450|7506->4452|7691->4606
                    LINES: 56->18|59->18|70->29|70->29|70->29|71->30|71->30|71->30|76->35|76->35|76->35|83->42|83->42|83->42|84->43|84->43|84->43|87->46|88->47|89->48|90->49|91->50|92->51|93->52|94->53|100->59|100->59|100->59|101->60|101->60|101->60|102->61|102->61|102->61|110->69|110->69|110->69|111->70|111->70|111->70|115->74|115->74|115->74|116->75|116->75|116->75|119->78|119->78|119->78|129->88|129->88|129->88|131->90|131->90|131->90|134->93|136->95|136->95|136->95|140->99
                    -- GENERATED --
                */
            