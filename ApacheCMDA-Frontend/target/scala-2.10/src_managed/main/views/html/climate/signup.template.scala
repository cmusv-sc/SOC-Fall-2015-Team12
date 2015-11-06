
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
object signup extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(userName: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*18.20*/("""

"""),_display_(Seq[Any](/*20.2*/main("About Us")/*20.18*/ {_display_(Seq[Any](format.raw/*20.20*/("""

   <h1>Login</h1>
   	<div class="jumbotron">
   <p>Hello """),_display_(Seq[Any](/*24.14*/userName)),format.raw/*24.22*/("""</p>
   <br>
</div>
""")))})),format.raw/*27.2*/("""
"""))}
    }
    
    def render(userName:String): play.api.templates.HtmlFormat.Appendable = apply(userName)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (userName) => apply(userName)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Nov 06 13:49:04 PST 2015
                    SOURCE: /Users/feifei/SOC-Fall-2015-Team12/ApacheCMDA-Frontend/app/views/climate/signup.scala.html
                    HASH: 762f6e544345bac46b84156ff9482d5fc73c3563
                    MATRIX: 3178->1204|3291->1222|3329->1225|3354->1241|3394->1243|3491->1304|3521->1312|3573->1333
                    LINES: 56->18|59->18|61->20|61->20|61->20|65->24|65->24|68->27
                    -- GENERATED --
                */
            