// @SOURCE:/Users/K/SOC-Team12-Final-Version/SOC-ApacheCMDA-Backend/conf/routes
// @HASH:fff86830dd4011284f12c116227a023a21a79d96
// @DATE:Fri Dec 11 14:50:28 PST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:10
private[this] lazy val controllers_ClimateServiceController_getClimateService0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getClimateService/"),DynamicPart("name", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_ClimateServiceController_getClimateService0_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateService(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getClimateService", Seq(classOf[String], classOf[String]),"GET", """ Climate Service""", Routes.prefix + """climateService/getClimateService/$name<[^/]+>/json"""))
        

// @LINE:11
private[this] lazy val controllers_ClimateServiceController_getClimateServiceById1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getClimateService/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_getClimateServiceById1_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateServiceById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getClimateServiceById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """climateService/getClimateService/id/$id<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_ClimateServiceController_getAllClimateServices2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllClimateServices/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServices2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServices(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServices", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllClimateServices/json"""))
        

// @LINE:13
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllMostRecentClimateServicesByCreateTime/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCreateTime(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByCreateTime", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllMostRecentClimateServicesByCreateTime/json"""))
        

// @LINE:14
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllMostRecentClimateServicesByLatestAccessTime/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByLatestAccessTime(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByLatestAccessTime", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllMostRecentClimateServicesByLatestAccessTime/json"""))
        

// @LINE:15
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllMostUsedClimateServices/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCount(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByCount", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllMostUsedClimateServices/json"""))
        

// @LINE:16
private[this] lazy val controllers_ClimateServiceController_addClimateService6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/addClimateService"))))
private[this] lazy val controllers_ClimateServiceController_addClimateService6_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addClimateService,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "addClimateService", Nil,"POST", """""", Routes.prefix + """climateService/addClimateService"""))
        

// @LINE:17
private[this] lazy val controllers_ClimateServiceController_getAllServiceEntries7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllServiceEntries/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllServiceEntries7_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllServiceEntries(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllServiceEntries", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllServiceEntries/json"""))
        

// @LINE:18
private[this] lazy val controllers_ClimateServiceController_addServiceEntry8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/addServiceEntry"))))
private[this] lazy val controllers_ClimateServiceController_addServiceEntry8_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addServiceEntry,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "addServiceEntry", Nil,"POST", """""", Routes.prefix + """climateService/addServiceEntry"""))
        

// @LINE:19
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceById9_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/updateClimateService/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceById9_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "updateClimateServiceById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """climateService/updateClimateService/id/$id<[^/]+>"""))
        

// @LINE:20
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceByName10_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/updateClimateService/name/"),DynamicPart("oldName", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceByName10_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceByName(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "updateClimateServiceByName", Seq(classOf[String]),"PUT", """""", Routes.prefix + """climateService/updateClimateService/name/$oldName<[^/]+>"""))
        

// @LINE:21
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceById11_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/deleteClimateService/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceById11_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "deleteClimateServiceById", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """climateService/deleteClimateService/id/$id<[^/]+>"""))
        

// @LINE:22
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceByName12_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/deleteClimateService/name/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceByName12_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceByName(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "deleteClimateServiceByName", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """climateService/deleteClimateService/name/$name<[^/]+>"""))
        

// @LINE:25
private[this] lazy val controllers_InstrumentController_getAllInstruments13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/getAllInstruments/json"))))
private[this] lazy val controllers_InstrumentController_getAllInstruments13_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getAllInstruments(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "getAllInstruments", Seq(classOf[String]),"GET", """ Instrument""", Routes.prefix + """instrument/getAllInstruments/json"""))
        

// @LINE:26
private[this] lazy val controllers_InstrumentController_getInstrument14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/getInstrument/id/"),DynamicPart("id", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_InstrumentController_getInstrument14_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getInstrument(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "getInstrument", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """instrument/getInstrument/id/$id<[^/]+>/json"""))
        

// @LINE:27
private[this] lazy val controllers_InstrumentController_addInstrument15_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/addInstrument"))))
private[this] lazy val controllers_InstrumentController_addInstrument15_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).addInstrument,
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "addInstrument", Nil,"POST", """""", Routes.prefix + """instrument/addInstrument"""))
        

// @LINE:28
private[this] lazy val controllers_InstrumentController_updateInstrumentById16_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/updateInstrument/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_InstrumentController_updateInstrumentById16_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).updateInstrumentById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "updateInstrumentById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """instrument/updateInstrument/id/$id<[^/]+>"""))
        

// @LINE:29
private[this] lazy val controllers_InstrumentController_deleteInstrument17_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/deleteInstrument/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_InstrumentController_deleteInstrument17_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).deleteInstrument(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "deleteInstrument", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """instrument/deleteInstrument/id/$id<[^/]+>"""))
        

// @LINE:32
private[this] lazy val controllers_DatasetController_getAllDatasets18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/getAllDatasets/json"))))
private[this] lazy val controllers_DatasetController_getAllDatasets18_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getAllDatasets(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "getAllDatasets", Seq(classOf[String]),"GET", """ Dataset""", Routes.prefix + """dataset/getAllDatasets/json"""))
        

// @LINE:33
private[this] lazy val controllers_DatasetController_getDataset19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/getDataset/id/"),DynamicPart("id", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_DatasetController_getDataset19_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getDataset(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "getDataset", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """dataset/getDataset/id/$id<[^/]+>/json"""))
        

// @LINE:34
private[this] lazy val controllers_DatasetController_addDataset20_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/addDataset"))))
private[this] lazy val controllers_DatasetController_addDataset20_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).addDataset,
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "addDataset", Nil,"POST", """""", Routes.prefix + """dataset/addDataset"""))
        

// @LINE:35
private[this] lazy val controllers_DatasetController_updateDatasetById21_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/updateDataset/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_DatasetController_updateDatasetById21_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).updateDatasetById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "updateDatasetById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """dataset/updateDataset/id/$id<[^/]+>"""))
        

// @LINE:36
private[this] lazy val controllers_DatasetController_deleteDataset22_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/deleteDataset/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_DatasetController_deleteDataset22_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).deleteDataset(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "deleteDataset", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """dataset/deleteDataset/id/$id<[^/]+>"""))
        

// @LINE:37
private[this] lazy val controllers_DatasetController_queryDatasets23_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/queryDataset"))))
private[this] lazy val controllers_DatasetController_queryDatasets23_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).queryDatasets,
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "queryDatasets", Nil,"POST", """""", Routes.prefix + """dataset/queryDataset"""))
        

// @LINE:40
private[this] lazy val controllers_ParameterController_getAllParameters24_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/getAllParameters/json"))))
private[this] lazy val controllers_ParameterController_getAllParameters24_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getAllParameters(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getAllParameters", Seq(classOf[String]),"GET", """ Parameter""", Routes.prefix + """parameter/getAllParameters/json"""))
        

// @LINE:41
private[this] lazy val controllers_ParameterController_getParameterByName25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/getParameter/service/"),DynamicPart("id", """[^/]+""",true),StaticPart("/name/"),DynamicPart("name", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_ParameterController_getParameterByName25_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterByName(fakeValue[Long], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getParameterByName", Seq(classOf[Long], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """parameter/getParameter/service/$id<[^/]+>/name/$name<[^/]+>/json"""))
        

// @LINE:42
private[this] lazy val controllers_ParameterController_getParameterById26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/getParameter/id/"),DynamicPart("id", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_ParameterController_getParameterById26_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterById(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getParameterById", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """parameter/getParameter/id/$id<[^/]+>/json"""))
        

// @LINE:43
private[this] lazy val controllers_ParameterController_addParameter27_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/addParameter"))))
private[this] lazy val controllers_ParameterController_addParameter27_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).addParameter,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "addParameter", Nil,"POST", """""", Routes.prefix + """parameter/addParameter"""))
        

// @LINE:44
private[this] lazy val controllers_ParameterController_updateParameterById28_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/updateParameter/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ParameterController_updateParameterById28_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "updateParameterById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """parameter/updateParameter/id/$id<[^/]+>"""))
        

// @LINE:45
private[this] lazy val controllers_ParameterController_updateParameterByName29_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/updateParameter/name/"),DynamicPart("oldName", """[^/]+""",true))))
private[this] lazy val controllers_ParameterController_updateParameterByName29_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterByName(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "updateParameterByName", Seq(classOf[String]),"PUT", """""", Routes.prefix + """parameter/updateParameter/name/$oldName<[^/]+>"""))
        

// @LINE:46
private[this] lazy val controllers_ParameterController_deleteParameterByName30_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/deleteParameter/service/"),DynamicPart("id", """[^/]+""",true),StaticPart("/name/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_ParameterController_deleteParameterByName30_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).deleteParameterByName(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "deleteParameterByName", Seq(classOf[Long], classOf[String]),"DELETE", """""", Routes.prefix + """parameter/deleteParameter/service/$id<[^/]+>/name/$name<[^/]+>"""))
        

// @LINE:49
private[this] lazy val controllers_UserController_getUser31_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_UserController_getUser31_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getUser(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "getUser", Seq(classOf[Long], classOf[String]),"GET", """ Users""", Routes.prefix + """users/$id<[^/]+>"""))
        

// @LINE:50
private[this] lazy val controllers_UserController_addUser32_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/add"))))
private[this] lazy val controllers_UserController_addUser32_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).addUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "addUser", Nil,"POST", """""", Routes.prefix + """users/add"""))
        

// @LINE:51
private[this] lazy val controllers_UserController_updateUser33_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/update/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_UserController_updateUser33_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).updateUser(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "updateUser", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """users/update/$id<[^/]+>"""))
        

// @LINE:52
private[this] lazy val controllers_UserController_deleteUser34_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/delete/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_UserController_deleteUser34_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUser(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "deleteUser", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """users/delete/$id<[^/]+>"""))
        

// @LINE:53
private[this] lazy val controllers_UserController_getAllUsers35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/getAllUsers/json"))))
private[this] lazy val controllers_UserController_getAllUsers35_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getAllUsers(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "getAllUsers", Seq(classOf[String]),"GET", """""", Routes.prefix + """users/getAllUsers/json"""))
        

// @LINE:54
private[this] lazy val controllers_UserController_isUserValid36_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/isUserValid"))))
private[this] lazy val controllers_UserController_isUserValid36_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isUserValid,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "isUserValid", Nil,"POST", """""", Routes.prefix + """users/isUserValid"""))
        

// @LINE:55
private[this] lazy val controllers_UserController_isEmailExisted37_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/isEmailExisted"))))
private[this] lazy val controllers_UserController_isEmailExisted37_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isEmailExisted,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "isEmailExisted", Nil,"POST", """""", Routes.prefix + """users/isEmailExisted"""))
        

// @LINE:56
private[this] lazy val controllers_UserController_deleteUserByUserNameandPassword38_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/delete/userName/"),DynamicPart("userName", """[^/]+""",true),StaticPart("/password/"),DynamicPart("password", """[^/]+""",true))))
private[this] lazy val controllers_UserController_deleteUserByUserNameandPassword38_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUserByUserNameandPassword(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "deleteUserByUserNameandPassword", Seq(classOf[String], classOf[String]),"DELETE", """""", Routes.prefix + """users/delete/userName/$userName<[^/]+>/password/$password<[^/]+>"""))
        

// @LINE:57
private[this] lazy val controllers_UserController_login39_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/login"))))
private[this] lazy val controllers_UserController_login39_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "login", Nil,"POST", """""", Routes.prefix + """users/login"""))
        

// @LINE:58
private[this] lazy val controllers_UserController_signUp40_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/signUp"))))
private[this] lazy val controllers_UserController_signUp40_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).signUp,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "signUp", Nil,"POST", """""", Routes.prefix + """users/signUp"""))
        

// @LINE:59
private[this] lazy val controllers_UserController_searchUser41_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/search/userName/"),DynamicPart("username", """[^/]+""",true),StaticPart("/id/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"),DynamicPart("status", """[^/]+""",true))))
private[this] lazy val controllers_UserController_searchUser41_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).searchUser(fakeValue[String], fakeValue[Long], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "searchUser", Seq(classOf[String], classOf[Long], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """users/search/userName/$username<[^/]+>/id/$id<[^/]+>/$status<[^/]+>"""))
        

// @LINE:62
private[this] lazy val controllers_PostController_getPostById42_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PostController_getPostById42_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPostById(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "getPostById", Seq(classOf[Long], classOf[String]),"GET", """ Posts""", Routes.prefix + """posts/$id<[^/]+>"""))
        

// @LINE:63
private[this] lazy val controllers_PostController_addPost43_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/add"))))
private[this] lazy val controllers_PostController_addPost43_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).addPost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "addPost", Nil,"POST", """""", Routes.prefix + """posts/add"""))
        

// @LINE:64
private[this] lazy val controllers_PostController_deletePostById44_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/delete/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PostController_deletePostById44_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).deletePostById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "deletePostById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """posts/delete/$id<[^/]+>"""))
        

// @LINE:65
private[this] lazy val controllers_PostController_updatePostById45_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/update/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_PostController_updatePostById45_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).updatePostById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "updatePostById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """posts/update/$id<[^/]+>"""))
        

// @LINE:66
private[this] lazy val controllers_PostController_getPublicPost46_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/getPublicPost/"),DynamicPart("userId", """[^/]+""",true),StaticPart("/"),DynamicPart("page", """[^/]+""",true))))
private[this] lazy val controllers_PostController_getPublicPost46_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPublicPost(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "getPublicPost", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """posts/getPublicPost/$userId<[^/]+>/$page<[^/]+>"""))
        

// @LINE:67
private[this] lazy val controllers_PostController_getPersonalPost47_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/getPersonalPost/"),DynamicPart("userId", """[^/]+""",true),StaticPart("/"),DynamicPart("page", """[^/]+""",true))))
private[this] lazy val controllers_PostController_getPersonalPost47_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPersonalPost(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "getPersonalPost", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """posts/getPersonalPost/$userId<[^/]+>/$page<[^/]+>"""))
        

// @LINE:68
private[this] lazy val controllers_PostController_getPersonalPostWithoutPage48_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/getPersonalPost/"),DynamicPart("userId", """[^/]+""",true))))
private[this] lazy val controllers_PostController_getPersonalPostWithoutPage48_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPersonalPostWithoutPage(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "getPersonalPostWithoutPage", Seq(classOf[String]),"GET", """""", Routes.prefix + """posts/getPersonalPost/$userId<[^/]+>"""))
        

// @LINE:69
private[this] lazy val controllers_PostController_getTop10Posts49_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/getTop10Posts/"),DynamicPart("userId", """[^/]+""",true))))
private[this] lazy val controllers_PostController_getTop10Posts49_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getTop10Posts(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "getTop10Posts", Seq(classOf[Long]),"GET", """""", Routes.prefix + """posts/getTop10Posts/$userId<[^/]+>"""))
        

// @LINE:70
private[this] lazy val controllers_PostController_searchPost50_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/search/userId/"),DynamicPart("userId", """[^/]+""",true),StaticPart("/keyword/"),DynamicPart("keyword", """[^/]+""",true))))
private[this] lazy val controllers_PostController_searchPost50_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).searchPost(fakeValue[String], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "searchPost", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """posts/search/userId/$userId<[^/]+>/keyword/$keyword<[^/]+>"""))
        

// @LINE:71
private[this] lazy val controllers_PostController_sharePost51_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("posts/share"))))
private[this] lazy val controllers_PostController_sharePost51_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).sharePost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.PostController", "sharePost", Nil,"POST", """""", Routes.prefix + """posts/share"""))
        

// @LINE:74
private[this] lazy val controllers_CommentController_addComment52_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comments/add"))))
private[this] lazy val controllers_CommentController_addComment52_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.CommentController]).addComment,
HandlerDef(this.getClass.getClassLoader, "", "controllers.CommentController", "addComment", Nil,"POST", """ Comments and Likes""", Routes.prefix + """comments/add"""))
        

// @LINE:75
private[this] lazy val controllers_LikeController_addLike53_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("likes/add"))))
private[this] lazy val controllers_LikeController_addLike53_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LikeController]).addLike,
HandlerDef(this.getClass.getClassLoader, "", "controllers.LikeController", "addLike", Nil,"POST", """""", Routes.prefix + """likes/add"""))
        

// @LINE:76
private[this] lazy val controllers_LikeController_getNumOfLikes54_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("likes/getNumOfLikes/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_LikeController_getNumOfLikes54_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LikeController]).getNumOfLikes(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.LikeController", "getNumOfLikes", Seq(classOf[Long]),"GET", """""", Routes.prefix + """likes/getNumOfLikes/$id<[^/]+>"""))
        

// @LINE:79
private[this] lazy val controllers_FollowController_addFollow55_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("follow/add"))))
private[this] lazy val controllers_FollowController_addFollow55_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).addFollow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.FollowController", "addFollow", Nil,"POST", """ Follow""", Routes.prefix + """follow/add"""))
        

// @LINE:80
private[this] lazy val controllers_FollowController_deleteFollowById56_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("follow/delete/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_FollowController_deleteFollowById56_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).deleteFollowById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.FollowController", "deleteFollowById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """follow/delete/$id<[^/]+>"""))
        

// @LINE:82
private[this] lazy val controllers_FollowController_getTopFollowee57_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("follow/getTopFollowee"))))
private[this] lazy val controllers_FollowController_getTopFollowee57_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).getTopFollowee(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.FollowController", "getTopFollowee", Nil,"GET", """POST		  /follow/isExisted                     													 @controllers.FollowController.isExisted""", Routes.prefix + """follow/getTopFollowee"""))
        

// @LINE:83
private[this] lazy val controllers_FollowController_getFollowerById58_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("follow/getFollower/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_FollowController_getFollowerById58_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).getFollowerById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.FollowController", "getFollowerById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """follow/getFollower/$id<[^/]+>"""))
        

// @LINE:86
private[this] lazy val controllers_Assets_at59_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at59_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getClimateService/$name<[^/]+>/json""","""@controllers.ClimateServiceController@.getClimateService(name:String, format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getClimateService/id/$id<[^/]+>""","""@controllers.ClimateServiceController@.getClimateServiceById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllClimateServices/json""","""@controllers.ClimateServiceController@.getAllClimateServices(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllMostRecentClimateServicesByCreateTime/json""","""@controllers.ClimateServiceController@.getAllClimateServicesOrderByCreateTime(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllMostRecentClimateServicesByLatestAccessTime/json""","""@controllers.ClimateServiceController@.getAllClimateServicesOrderByLatestAccessTime(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllMostUsedClimateServices/json""","""@controllers.ClimateServiceController@.getAllClimateServicesOrderByCount(format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/addClimateService""","""@controllers.ClimateServiceController@.addClimateService"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllServiceEntries/json""","""@controllers.ClimateServiceController@.getAllServiceEntries(format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/addServiceEntry""","""@controllers.ClimateServiceController@.addServiceEntry"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/updateClimateService/id/$id<[^/]+>""","""@controllers.ClimateServiceController@.updateClimateServiceById(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/updateClimateService/name/$oldName<[^/]+>""","""@controllers.ClimateServiceController@.updateClimateServiceByName(oldName:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/deleteClimateService/id/$id<[^/]+>""","""@controllers.ClimateServiceController@.deleteClimateServiceById(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/deleteClimateService/name/$name<[^/]+>""","""@controllers.ClimateServiceController@.deleteClimateServiceByName(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/getAllInstruments/json""","""@controllers.InstrumentController@.getAllInstruments(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/getInstrument/id/$id<[^/]+>/json""","""@controllers.InstrumentController@.getInstrument(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/addInstrument""","""@controllers.InstrumentController@.addInstrument"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/updateInstrument/id/$id<[^/]+>""","""@controllers.InstrumentController@.updateInstrumentById(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/deleteInstrument/id/$id<[^/]+>""","""@controllers.InstrumentController@.deleteInstrument(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/getAllDatasets/json""","""@controllers.DatasetController@.getAllDatasets(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/getDataset/id/$id<[^/]+>/json""","""@controllers.DatasetController@.getDataset(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/addDataset""","""@controllers.DatasetController@.addDataset"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/updateDataset/id/$id<[^/]+>""","""@controllers.DatasetController@.updateDatasetById(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/deleteDataset/id/$id<[^/]+>""","""@controllers.DatasetController@.deleteDataset(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/queryDataset""","""@controllers.DatasetController@.queryDatasets"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/getAllParameters/json""","""@controllers.ParameterController@.getAllParameters(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/getParameter/service/$id<[^/]+>/name/$name<[^/]+>/json""","""@controllers.ParameterController@.getParameterByName(id:Long, name:String, format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/getParameter/id/$id<[^/]+>/json""","""@controllers.ParameterController@.getParameterById(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/addParameter""","""@controllers.ParameterController@.addParameter"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/updateParameter/id/$id<[^/]+>""","""@controllers.ParameterController@.updateParameterById(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/updateParameter/name/$oldName<[^/]+>""","""@controllers.ParameterController@.updateParameterByName(oldName:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/deleteParameter/service/$id<[^/]+>/name/$name<[^/]+>""","""@controllers.ParameterController@.deleteParameterByName(id:Long, name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/$id<[^/]+>""","""@controllers.UserController@.getUser(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/add""","""@controllers.UserController@.addUser"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/update/$id<[^/]+>""","""@controllers.UserController@.updateUser(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/delete/$id<[^/]+>""","""@controllers.UserController@.deleteUser(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/getAllUsers/json""","""@controllers.UserController@.getAllUsers(format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/isUserValid""","""@controllers.UserController@.isUserValid"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/isEmailExisted""","""@controllers.UserController@.isEmailExisted"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/delete/userName/$userName<[^/]+>/password/$password<[^/]+>""","""@controllers.UserController@.deleteUserByUserNameandPassword(userName:String, password:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/login""","""@controllers.UserController@.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/signUp""","""@controllers.UserController@.signUp"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/search/userName/$username<[^/]+>/id/$id<[^/]+>/$status<[^/]+>""","""@controllers.UserController@.searchUser(username:String, id:Long, status:String, format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/$id<[^/]+>""","""@controllers.PostController@.getPostById(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/add""","""@controllers.PostController@.addPost"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/delete/$id<[^/]+>""","""@controllers.PostController@.deletePostById(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/update/$id<[^/]+>""","""@controllers.PostController@.updatePostById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/getPublicPost/$userId<[^/]+>/$page<[^/]+>""","""@controllers.PostController@.getPublicPost(userId:String, page:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/getPersonalPost/$userId<[^/]+>/$page<[^/]+>""","""@controllers.PostController@.getPersonalPost(userId:String, page:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/getPersonalPost/$userId<[^/]+>""","""@controllers.PostController@.getPersonalPostWithoutPage(userId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/getTop10Posts/$userId<[^/]+>""","""@controllers.PostController@.getTop10Posts(userId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/search/userId/$userId<[^/]+>/keyword/$keyword<[^/]+>""","""@controllers.PostController@.searchPost(userId:String, keyword:String, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """posts/share""","""@controllers.PostController@.sharePost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comments/add""","""@controllers.CommentController@.addComment"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """likes/add""","""@controllers.LikeController@.addLike"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """likes/getNumOfLikes/$id<[^/]+>""","""@controllers.LikeController@.getNumOfLikes(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """follow/add""","""@controllers.FollowController@.addFollow"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """follow/delete/$id<[^/]+>""","""@controllers.FollowController@.deleteFollowById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """follow/getTopFollowee""","""@controllers.FollowController@.getTopFollowee()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """follow/getFollower/$id<[^/]+>""","""@controllers.FollowController@.getFollowerById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:10
case controllers_ClimateServiceController_getClimateService0_route(params) => {
   call(params.fromPath[String]("name", None), Param[String]("format", Right("json"))) { (name, format) =>
        controllers_ClimateServiceController_getClimateService0_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateService(name, format))
   }
}
        

// @LINE:11
case controllers_ClimateServiceController_getClimateServiceById1_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ClimateServiceController_getClimateServiceById1_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateServiceById(id))
   }
}
        

// @LINE:12
case controllers_ClimateServiceController_getAllClimateServices2_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServices2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServices(format))
   }
}
        

// @LINE:13
case controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCreateTime(format))
   }
}
        

// @LINE:14
case controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByLatestAccessTime(format))
   }
}
        

// @LINE:15
case controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCount(format))
   }
}
        

// @LINE:16
case controllers_ClimateServiceController_addClimateService6_route(params) => {
   call { 
        controllers_ClimateServiceController_addClimateService6_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addClimateService)
   }
}
        

// @LINE:17
case controllers_ClimateServiceController_getAllServiceEntries7_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllServiceEntries7_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllServiceEntries(format))
   }
}
        

// @LINE:18
case controllers_ClimateServiceController_addServiceEntry8_route(params) => {
   call { 
        controllers_ClimateServiceController_addServiceEntry8_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addServiceEntry)
   }
}
        

// @LINE:19
case controllers_ClimateServiceController_updateClimateServiceById9_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ClimateServiceController_updateClimateServiceById9_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceById(id))
   }
}
        

// @LINE:20
case controllers_ClimateServiceController_updateClimateServiceByName10_route(params) => {
   call(params.fromPath[String]("oldName", None)) { (oldName) =>
        controllers_ClimateServiceController_updateClimateServiceByName10_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceByName(oldName))
   }
}
        

// @LINE:21
case controllers_ClimateServiceController_deleteClimateServiceById11_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ClimateServiceController_deleteClimateServiceById11_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceById(id))
   }
}
        

// @LINE:22
case controllers_ClimateServiceController_deleteClimateServiceByName12_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_ClimateServiceController_deleteClimateServiceByName12_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceByName(name))
   }
}
        

// @LINE:25
case controllers_InstrumentController_getAllInstruments13_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_InstrumentController_getAllInstruments13_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getAllInstruments(format))
   }
}
        

// @LINE:26
case controllers_InstrumentController_getInstrument14_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_InstrumentController_getInstrument14_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getInstrument(id, format))
   }
}
        

// @LINE:27
case controllers_InstrumentController_addInstrument15_route(params) => {
   call { 
        controllers_InstrumentController_addInstrument15_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).addInstrument)
   }
}
        

// @LINE:28
case controllers_InstrumentController_updateInstrumentById16_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_InstrumentController_updateInstrumentById16_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).updateInstrumentById(id))
   }
}
        

// @LINE:29
case controllers_InstrumentController_deleteInstrument17_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_InstrumentController_deleteInstrument17_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).deleteInstrument(id))
   }
}
        

// @LINE:32
case controllers_DatasetController_getAllDatasets18_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_DatasetController_getAllDatasets18_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getAllDatasets(format))
   }
}
        

// @LINE:33
case controllers_DatasetController_getDataset19_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_DatasetController_getDataset19_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getDataset(id, format))
   }
}
        

// @LINE:34
case controllers_DatasetController_addDataset20_route(params) => {
   call { 
        controllers_DatasetController_addDataset20_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).addDataset)
   }
}
        

// @LINE:35
case controllers_DatasetController_updateDatasetById21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DatasetController_updateDatasetById21_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).updateDatasetById(id))
   }
}
        

// @LINE:36
case controllers_DatasetController_deleteDataset22_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DatasetController_deleteDataset22_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).deleteDataset(id))
   }
}
        

// @LINE:37
case controllers_DatasetController_queryDatasets23_route(params) => {
   call { 
        controllers_DatasetController_queryDatasets23_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).queryDatasets)
   }
}
        

// @LINE:40
case controllers_ParameterController_getAllParameters24_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ParameterController_getAllParameters24_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getAllParameters(format))
   }
}
        

// @LINE:41
case controllers_ParameterController_getParameterByName25_route(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[String]("name", None), Param[String]("format", Right("json"))) { (id, name, format) =>
        controllers_ParameterController_getParameterByName25_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterByName(id, name, format))
   }
}
        

// @LINE:42
case controllers_ParameterController_getParameterById26_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_ParameterController_getParameterById26_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterById(id, format))
   }
}
        

// @LINE:43
case controllers_ParameterController_addParameter27_route(params) => {
   call { 
        controllers_ParameterController_addParameter27_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).addParameter)
   }
}
        

// @LINE:44
case controllers_ParameterController_updateParameterById28_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ParameterController_updateParameterById28_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterById(id))
   }
}
        

// @LINE:45
case controllers_ParameterController_updateParameterByName29_route(params) => {
   call(params.fromPath[String]("oldName", None)) { (oldName) =>
        controllers_ParameterController_updateParameterByName29_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterByName(oldName))
   }
}
        

// @LINE:46
case controllers_ParameterController_deleteParameterByName30_route(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[String]("name", None)) { (id, name) =>
        controllers_ParameterController_deleteParameterByName30_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).deleteParameterByName(id, name))
   }
}
        

// @LINE:49
case controllers_UserController_getUser31_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_UserController_getUser31_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getUser(id, format))
   }
}
        

// @LINE:50
case controllers_UserController_addUser32_route(params) => {
   call { 
        controllers_UserController_addUser32_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).addUser)
   }
}
        

// @LINE:51
case controllers_UserController_updateUser33_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_updateUser33_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).updateUser(id))
   }
}
        

// @LINE:52
case controllers_UserController_deleteUser34_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_deleteUser34_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUser(id))
   }
}
        

// @LINE:53
case controllers_UserController_getAllUsers35_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_UserController_getAllUsers35_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getAllUsers(format))
   }
}
        

// @LINE:54
case controllers_UserController_isUserValid36_route(params) => {
   call { 
        controllers_UserController_isUserValid36_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isUserValid)
   }
}
        

// @LINE:55
case controllers_UserController_isEmailExisted37_route(params) => {
   call { 
        controllers_UserController_isEmailExisted37_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isEmailExisted)
   }
}
        

// @LINE:56
case controllers_UserController_deleteUserByUserNameandPassword38_route(params) => {
   call(params.fromPath[String]("userName", None), params.fromPath[String]("password", None)) { (userName, password) =>
        controllers_UserController_deleteUserByUserNameandPassword38_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUserByUserNameandPassword(userName, password))
   }
}
        

// @LINE:57
case controllers_UserController_login39_route(params) => {
   call { 
        controllers_UserController_login39_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).login)
   }
}
        

// @LINE:58
case controllers_UserController_signUp40_route(params) => {
   call { 
        controllers_UserController_signUp40_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).signUp)
   }
}
        

// @LINE:59
case controllers_UserController_searchUser41_route(params) => {
   call(params.fromPath[String]("username", None), params.fromPath[Long]("id", None), params.fromPath[String]("status", None), Param[String]("format", Right("json"))) { (username, id, status, format) =>
        controllers_UserController_searchUser41_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).searchUser(username, id, status, format))
   }
}
        

// @LINE:62
case controllers_PostController_getPostById42_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_PostController_getPostById42_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPostById(id, format))
   }
}
        

// @LINE:63
case controllers_PostController_addPost43_route(params) => {
   call { 
        controllers_PostController_addPost43_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).addPost)
   }
}
        

// @LINE:64
case controllers_PostController_deletePostById44_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PostController_deletePostById44_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).deletePostById(id))
   }
}
        

// @LINE:65
case controllers_PostController_updatePostById45_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PostController_updatePostById45_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).updatePostById(id))
   }
}
        

// @LINE:66
case controllers_PostController_getPublicPost46_route(params) => {
   call(params.fromPath[String]("userId", None), params.fromPath[String]("page", None)) { (userId, page) =>
        controllers_PostController_getPublicPost46_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPublicPost(userId, page))
   }
}
        

// @LINE:67
case controllers_PostController_getPersonalPost47_route(params) => {
   call(params.fromPath[String]("userId", None), params.fromPath[String]("page", None)) { (userId, page) =>
        controllers_PostController_getPersonalPost47_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPersonalPost(userId, page))
   }
}
        

// @LINE:68
case controllers_PostController_getPersonalPostWithoutPage48_route(params) => {
   call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_PostController_getPersonalPostWithoutPage48_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getPersonalPostWithoutPage(userId))
   }
}
        

// @LINE:69
case controllers_PostController_getTop10Posts49_route(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_PostController_getTop10Posts49_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).getTop10Posts(userId))
   }
}
        

// @LINE:70
case controllers_PostController_searchPost50_route(params) => {
   call(params.fromPath[String]("userId", None), params.fromPath[String]("keyword", None), Param[String]("format", Right("json"))) { (userId, keyword, format) =>
        controllers_PostController_searchPost50_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).searchPost(userId, keyword, format))
   }
}
        

// @LINE:71
case controllers_PostController_sharePost51_route(params) => {
   call { 
        controllers_PostController_sharePost51_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.PostController]).sharePost)
   }
}
        

// @LINE:74
case controllers_CommentController_addComment52_route(params) => {
   call { 
        controllers_CommentController_addComment52_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.CommentController]).addComment)
   }
}
        

// @LINE:75
case controllers_LikeController_addLike53_route(params) => {
   call { 
        controllers_LikeController_addLike53_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LikeController]).addLike)
   }
}
        

// @LINE:76
case controllers_LikeController_getNumOfLikes54_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_LikeController_getNumOfLikes54_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.LikeController]).getNumOfLikes(id))
   }
}
        

// @LINE:79
case controllers_FollowController_addFollow55_route(params) => {
   call { 
        controllers_FollowController_addFollow55_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).addFollow)
   }
}
        

// @LINE:80
case controllers_FollowController_deleteFollowById56_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_FollowController_deleteFollowById56_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).deleteFollowById(id))
   }
}
        

// @LINE:82
case controllers_FollowController_getTopFollowee57_route(params) => {
   call { 
        controllers_FollowController_getTopFollowee57_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).getTopFollowee())
   }
}
        

// @LINE:83
case controllers_FollowController_getFollowerById58_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_FollowController_getFollowerById58_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FollowController]).getFollowerById(id))
   }
}
        

// @LINE:86
case controllers_Assets_at59_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at59_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     