
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
object userSetList extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[UserSet],play.data.Form[UserSet],play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(userSets: List[UserSet], userSetForm: play.data.Form[UserSet]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*22.2*/scripts/*22.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*22.13*/("""
	<script src='"""),_display_(Seq[Any](/*23.16*/routes/*23.22*/.Assets.at("javascripts/edit_button.js"))),format.raw/*23.62*/("""'></script>
	<script type="text/javascript">
	$(document).ready(function()"""),format.raw/*25.30*/("""{"""),format.raw/*25.31*/("""
		//alert($("#url").text());
	"""),format.raw/*27.2*/("""}"""),format.raw/*27.3*/(""");
	</script>
""")))};
Seq[Any](format.raw/*18.65*/("""

"""),format.raw/*21.1*/("""
"""),format.raw/*29.2*/("""

"""),_display_(Seq[Any](/*31.2*/main("Userset List", scripts)/*31.31*/ {_display_(Seq[Any](format.raw/*31.33*/("""
	
	"""),_display_(Seq[Any](/*33.3*/flash_message())),format.raw/*33.18*/("""   
	 
    <h1>Usersets</h1>
    <h2>"""),_display_(Seq[Any](/*36.10*/userSets/*36.18*/.size())),format.raw/*36.25*/(""" Usersets Found</h2>
    <div style="overflow-y:scroll">

		<table class="table table-striped table-bordered table-condensed tablesorter" id ="myTable">
		<thead>
	<tr >
		<th style = "vertical-align: top;" class="col-md-2">Username</th>
		<th style = "vertical-align: top;" class="col-md-1">Password</th>

	</tr>
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*48.3*/for(userSet <- userSets) yield /*48.27*/{_display_(Seq[Any](format.raw/*48.28*/("""
	<tr>
		<td><font size="2">"""),_display_(Seq[Any](/*50.23*/userSet/*50.30*/.getUsername())),format.raw/*50.44*/("""</font></td>
		<td><font size="2">"""),_display_(Seq[Any](/*51.23*/userSet/*51.30*/.getPassword())),format.raw/*51.44*/("""</font></td>
	</tr>
	
	""")))})),format.raw/*54.3*/("""
	</tbody>
    </table>
    
 
    
    </div>
""")))})),format.raw/*61.2*/("""
"""))}
    }
    
    def render(userSets:List[UserSet],userSetForm:play.data.Form[UserSet]): play.api.templates.HtmlFormat.Appendable = apply(userSets,userSetForm)
    
    def f:((List[UserSet],play.data.Form[UserSet]) => play.api.templates.HtmlFormat.Appendable) = (userSets,userSetForm) => apply(userSets,userSetForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Nov 06 09:34:11 PST 2015
                    SOURCE: /Users/feifei/SOC-Fall-2015-Team12/ApacheCMDA-Frontend/app/views/climate/userSetList.scala.html
                    HASH: 6dea8e8352c5f11949a23607bf70159baeb92d39
                    MATRIX: 3214->1205|3371->1289|3386->1296|3471->1300|3523->1316|3538->1322|3600->1362|3702->1436|3731->1437|3789->1468|3817->1469|3872->1268|3901->1287|3929->1484|3967->1487|4005->1516|4045->1518|4085->1523|4122->1538|4196->1576|4213->1584|4242->1591|4612->1926|4652->1950|4691->1951|4756->1980|4772->1987|4808->2001|4879->2036|4895->2043|4931->2057|4986->2081|5065->2129
                    LINES: 56->18|59->22|59->22|61->22|62->23|62->23|62->23|64->25|64->25|66->27|66->27|69->18|71->21|72->29|74->31|74->31|74->31|76->33|76->33|79->36|79->36|79->36|91->48|91->48|91->48|93->50|93->50|93->50|94->51|94->51|94->51|97->54|104->61
                    -- GENERATED --
                */
            