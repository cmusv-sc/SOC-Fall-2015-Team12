
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
object home extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,String,play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(email: String, vfile: String, dataset: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._ 


Seq[Any](format.raw/*18.49*/("""

"""),format.raw/*21.1*/("""
"""),_display_(Seq[Any](/*22.2*/main("Home")/*22.14*/ {_display_(Seq[Any](format.raw/*22.16*/("""

<div class="jumbotron">
	<div class="row">

		<div class="col-lg-5">
			</br></br>
			<img src="/assets/images/main.jpg" height="480" width="330" />
		</div>
		<div class="col-lg-6">
			<h2>Climate Model Diagnostic Analyzer</h2>

			<p> This repository is specially customized to support the 2015 JPL Center
				for Climate Sciences Summer School. The theme of the summer school is 
				<b>Using Satellite Observations to Advance Climate Models</b>. This repository 
				provides datasets and analysis tools for the students to use for their 
				group research projects.
			</p>
			
			<!-- """),_display_(Seq[Any](/*41.10*/if(!session.get("username"))/*41.38*/{_display_(Seq[Any](format.raw/*41.39*/(""" -->
			
			<p>
				"""),_display_(Seq[Any](/*44.6*/if(false)/*44.15*/{_display_(Seq[Any](format.raw/*44.16*/(""" <a class="btn btn-primary" href="climate/register"
					role="button">Register &raquo;</a> """)))})),format.raw/*45.42*/("""
			</p>
			<!-- """)))})),format.raw/*47.10*/(""" -->
		</div>
	</div>
</div>

""")))})),format.raw/*52.2*/("""
"""))}
    }
    
    def render(email:String,vfile:String,dataset:String): play.api.templates.HtmlFormat.Appendable = apply(email,vfile,dataset)
    
    def f:((String,String,String) => play.api.templates.HtmlFormat.Appendable) = (email,vfile,dataset) => apply(email,vfile,dataset)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 14:49:59 PST 2015
                    SOURCE: /Users/K/SOC-Team12-Final-Version/SOC-ApacheCMDA-Frontend/app/views/climate/home.scala.html
                    HASH: c42dbe74b06629e210b001693cbde8292ae3e1a2
                    MATRIX: 3190->1205|3349->1252|3378->1272|3415->1274|3436->1286|3476->1288|4107->1883|4144->1911|4183->1912|4239->1933|4257->1942|4296->1943|4421->2036|4471->2054|4533->2085
                    LINES: 56->18|60->18|62->21|63->22|63->22|63->22|82->41|82->41|82->41|85->44|85->44|85->44|86->45|88->47|93->52
                    -- GENERATED --
                */
            