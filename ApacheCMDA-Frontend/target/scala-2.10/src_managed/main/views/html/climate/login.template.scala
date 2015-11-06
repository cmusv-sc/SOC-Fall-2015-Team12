
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[UserSet],play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(userSetForm: play.data.Form[UserSet]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*22.2*/scripts/*22.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*22.13*/("""
<script src='"""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("javascripts/edit_button.js"))),format.raw/*23.61*/("""'></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<script type="text/javascript">
   $(function() """),format.raw/*28.17*/("""{"""),format.raw/*28.18*/("""
      $("#username").autocomplete("""),format.raw/*29.35*/("""{"""),format.raw/*29.36*/("""
      """),format.raw/*30.7*/("""}"""),format.raw/*30.8*/(""");
      $("#password").autocomplete("""),format.raw/*31.35*/("""{"""),format.raw/*31.36*/("""
      """),format.raw/*32.7*/("""}"""),format.raw/*32.8*/(""");
   """),format.raw/*33.4*/("""}"""),format.raw/*33.5*/(""");
</script>
""")))};
Seq[Any](format.raw/*18.40*/("""

"""),format.raw/*21.1*/("""
"""),format.raw/*35.2*/("""

"""),_display_(Seq[Any](/*37.2*/main("User login", scripts)/*37.29*/{_display_(Seq[Any](format.raw/*37.30*/("""

"""),_display_(Seq[Any](/*39.2*/flash_message())),format.raw/*39.17*/("""

<h1 style="margin-left:490px">User Login</h1>
"""),_display_(Seq[Any](/*42.2*/helper/*42.8*/.form(routes.User.getLoginResult())/*42.43*/ {_display_(Seq[Any](format.raw/*42.45*/("""
<div class="ui-widget col-sm-offset-3 col-sm-7">
   <div class = "form-group">
      """),_display_(Seq[Any](/*45.8*/inputText(userSetForm("User Name"), 'class -> "form-control", 'id -> "username", '_label -> Messages("User Name"), 'placeholder -> "Mike Wang", 'size->40))),format.raw/*45.162*/("""
   </div>
   <div class = "form-group">
      """),_display_(Seq[Any](/*48.8*/inputText(userSetForm("Password"), 'class -> "form-control", 'id -> "password", '_label -> Messages("Password"), 'placeholder -> "******", 'size->40))),format.raw/*48.157*/("""
   </div>

   <div align="center">
      <input class="btn" type="submit" value="Login">
   </div>

""")))})),format.raw/*55.2*/("""
""")))})))}
    }
    
    def render(userSetForm:play.data.Form[UserSet]): play.api.templates.HtmlFormat.Appendable = apply(userSetForm)
    
    def f:((play.data.Form[UserSet]) => play.api.templates.HtmlFormat.Appendable) = (userSetForm) => apply(userSetForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Nov 05 21:39:09 PST 2015
                    SOURCE: /Users/Qiyao/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/login.scala.html
                    HASH: 1264930ff248329ca2d0736c9c443532a77e72dd
                    MATRIX: 3194->1204|3326->1263|3341->1270|3426->1274|3477->1289|3492->1295|3554->1335|3857->1610|3886->1611|3949->1646|3978->1647|4012->1654|4040->1655|4105->1692|4134->1693|4168->1700|4196->1701|4229->1707|4257->1708|4311->1242|4340->1261|4368->1722|4406->1725|4442->1752|4481->1753|4519->1756|4556->1771|4640->1820|4654->1826|4698->1861|4738->1863|4860->1950|5037->2104|5120->2152|5292->2301|5425->2403
                    LINES: 56->18|59->22|59->22|61->22|62->23|62->23|62->23|67->28|67->28|68->29|68->29|69->30|69->30|70->31|70->31|71->32|71->32|72->33|72->33|75->18|77->21|78->35|80->37|80->37|80->37|82->39|82->39|85->42|85->42|85->42|85->42|88->45|88->45|91->48|91->48|98->55
                    -- GENERATED --
                */
            