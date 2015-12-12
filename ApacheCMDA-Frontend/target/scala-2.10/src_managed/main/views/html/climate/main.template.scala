
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(title: String, moreScripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*18.62*/(""" 

<!DOCTYPE html>
<html class="st-layout ls-top-navbar ls-bottom-footer show-sidebar sidebar-l2" lang="en">
	<head>
		<title>"""),_display_(Seq[Any](/*23.11*/title)),format.raw/*23.16*/("""</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<script src='"""),_display_(Seq[Any](/*30.17*/routes/*30.23*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*30.68*/("""'
		type="text/javascript"></script>
		<script src='"""),_display_(Seq[Any](/*32.17*/routes/*32.23*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*32.65*/("""'
		type="text/javascript"></script>
		<script type='text/javascript' src='"""),_display_(Seq[Any](/*34.40*/routes/*34.46*/.Assets.at("javascripts/lastLoader.js"))),format.raw/*34.85*/("""'></script>
		<script type='text/javascript' src='"""),_display_(Seq[Any](/*35.40*/routes/*35.46*/.Assets.at("javascripts/jquery.metadata.js"))),format.raw/*35.90*/("""'></script>
		<script type='text/javascript' src='"""),_display_(Seq[Any](/*36.40*/routes/*36.46*/.Assets.at("javascripts/jquery.tablesorter.js"))),format.raw/*36.93*/("""'></script>

		<script type='text/javascript' src='"""),_display_(Seq[Any](/*38.40*/routes/*38.46*/.Assets.at("javascripts/jstree.js"))),format.raw/*38.81*/("""'></script>
		<script type='text/javascript' src='"""),_display_(Seq[Any](/*39.40*/routes/*39.46*/.Assets.at("javascripts/keyword_tree.js"))),format.raw/*39.87*/("""'></script>

		<script src='"""),_display_(Seq[Any](/*41.17*/routes/*41.23*/.Assets.at("javascripts/bootstrap-editable.min.js"))),format.raw/*41.74*/("""'></script>

		<link href='"""),_display_(Seq[Any](/*43.16*/routes/*43.22*/.Assets.at("css/vendor/all.css"))),format.raw/*43.54*/("""' rel="stylesheet">

		<link href='"""),_display_(Seq[Any](/*45.16*/routes/*45.22*/.Assets.at("css/app/app.css"))),format.raw/*45.51*/("""' rel="stylesheet">

		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

		"""),_display_(Seq[Any](/*50.4*/moreScripts)),format.raw/*50.15*/("""
	</head>

	<body>
		<div class="st-container">
			"""),_display_(Seq[Any](/*55.5*/header())),format.raw/*55.13*/("""
			"""),_display_(Seq[Any](/*56.5*/content)),format.raw/*56.12*/("""
		</div>

			<!-- Footer -->
		<div class="footer" >
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<p class="text-muted" style="text-align: center; font-size: 14px;">Carnegie Mellon University - Silicon Valley ; SOC Team 12</p>
				</div>
			</div>
		</div>

	</body>
</html>"""))}
    }
    
    def render(title:String,moreScripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,moreScripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,moreScripts) => (content) => apply(title,moreScripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 14:49:59 PST 2015
                    SOURCE: /Users/K/SOC-Team12-Final-Version/SOC-ApacheCMDA-Frontend/app/views/climate/main.scala.html
                    HASH: 5745b3946cee02ae4e992018e4f736b371f5edff
                    MATRIX: 3186->1205|3341->1265|3504->1392|3531->1397|3818->1648|3833->1654|3900->1699|3989->1752|4004->1758|4068->1800|4180->1876|4195->1882|4256->1921|4343->1972|4358->1978|4424->2022|4511->2073|4526->2079|4595->2126|4683->2178|4698->2184|4755->2219|4842->2270|4857->2276|4920->2317|4985->2346|5000->2352|5073->2403|5137->2431|5152->2437|5206->2469|5278->2505|5293->2511|5344->2540|5564->2725|5597->2736|5684->2788|5714->2796|5754->2801|5783->2808
                    LINES: 56->18|59->18|64->23|64->23|71->30|71->30|71->30|73->32|73->32|73->32|75->34|75->34|75->34|76->35|76->35|76->35|77->36|77->36|77->36|79->38|79->38|79->38|80->39|80->39|80->39|82->41|82->41|82->41|84->43|84->43|84->43|86->45|86->45|86->45|91->50|91->50|96->55|96->55|97->56|97->56
                    -- GENERATED --
                */
            