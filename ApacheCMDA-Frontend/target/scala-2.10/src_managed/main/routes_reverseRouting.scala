// @SOURCE:/Users/K/SOC-Team12-Final-Version/SOC-ApacheCMDA-Frontend/conf/routes
// @HASH:4d7ae7d33bdd455c46019b61fcf02d0edfc3550a
// @DATE:Fri Dec 11 14:49:57 PST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:69
// @LINE:68
// @LINE:65
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:46
class ReverseAssets {
    

// @LINE:46
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:25
// @LINE:24
class ReverseAboutusController {
    

// @LINE:25
def aboutProject(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "aboutProject")
}
                                                

// @LINE:24
def aboutUs(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "aboutus")
}
                                                
    
}
                          

// @LINE:65
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
class ReverseHomePageController {
    

// @LINE:59
def nextPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "nextHomePage")
}
                                                

// @LINE:57
def homepage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "homepage")
}
                                                

// @LINE:65
def topPosts(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "topPosts")
}
                                                

// @LINE:62
def sharePost(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "sharePost")
}
                                                

// @LINE:61
def commentPost(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "commentPost")
}
                                                

// @LINE:60
def likePost(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "likePost")
}
                                                

// @LINE:58
def previousPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "previousHomePage")
}
                                                
    
}
                          

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseBugReportController {
    

// @LINE:17
def reports(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "bugs")
}
                                                

// @LINE:21
def solveReport(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "solve/report")
}
                                                

// @LINE:20
def deleteReport(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "delete/report")
}
                                                

// @LINE:19
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "bug/list")
}
                                                

// @LINE:18
def newReport(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "newReport")
}
                                                
    
}
                          

// @LINE:69
// @LINE:68
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
class ReverseMainPageController {
    

// @LINE:52
def nextPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "nextMainPage")
}
                                                

// @LINE:53
def createNewPost(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "createNewPost")
}
                                                

// @LINE:54
def editPost(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "editPost")
}
                                                

// @LINE:50
def mainpage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mainpage")
}
                                                

// @LINE:69
def searchPostsClick(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "searchPostsClick")
}
                                                

// @LINE:55
def deletePost(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deletePost")
}
                                                

// @LINE:51
def previousPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "previousMainPage")
}
                                                

// @LINE:68
def searchPosts(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "searchPosts")
}
                                                
    
}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:12
def createNewUser(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "createNewUser")
}
                                                

// @LINE:13
def createSuccess(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "createSuccess")
}
                                                

// @LINE:14
def isEmailExisted(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "isEmailExisted")
}
                                                

// @LINE:11
def signup(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:9
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:10
def authenticate(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "authenticate")
}
                                                

// @LINE:8
// @LINE:7
def login(): Call = {
   () match {
// @LINE:7
case () if true => Call("GET", _prefix)
                                                        
// @LINE:8
case () if true => Call("GET", _prefix + { _defaultPrefix } + "login")
                                                        
   }
}
                                                
    
}
                          

// @LINE:74
// @LINE:73
// @LINE:72
class ReverseSearchController {
    

// @LINE:74
def addfollow(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addfollow")
}
                                                

// @LINE:73
def searchUserClick(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "searchUsersClick")
}
                                                

// @LINE:72
def searchUser(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "searchUsers")
}
                                                
    
}
                          

// @LINE:43
// @LINE:42
// @LINE:41
class ReverseDatasetController {
    

// @LINE:43
def getSearchResult(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/getSearchResult")
}
                                                

// @LINE:42
def searchDataset(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/searchDataSet")
}
                                                

// @LINE:41
def datasetList(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/datasets")
}
                                                
    
}
                          

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:6
class ReverseClimateServiceController {
    

// @LINE:38
def addClimateServices(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/new/climateServices")
}
                                                

// @LINE:31
def mostRecentlyAddedClimateServices(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/mostRecentlyAddedClimateServices")
}
                                                

// @LINE:37
def editClimateService(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "climate/edit/climateServices")
}
                                                

// @LINE:33
def mostPopularClimateServices(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/mostPopularClimateServices")
}
                                                

// @LINE:29
def tutorial(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/tutorial")
}
                                                

// @LINE:39
def oneService(url:String = null): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/oneService" + queryString(List(if(url == null) None else Some(implicitly[QueryStringBindable[String]].unbind("url", url)))))
}
                                                

// @LINE:36
def downloadClimateService(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "climate/download/climateServices")
}
                                                

// @LINE:32
def mostRecentlyUsedClimateServices(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/mostRecentlyUsedClimateServices")
}
                                                

// @LINE:30
def climateServices(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "climate/climateServices")
}
                                                

// @LINE:34
def newClimateService(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "climate/new/climateServices")
}
                                                

// @LINE:28
// @LINE:6
def home(email:String = null, vfile:String = null, dataset:String = null): Call = {
   (email: @unchecked, vfile: @unchecked, dataset: @unchecked) match {
// @LINE:6
case (email, vfile, dataset) if true => Call("GET", _prefix + { _defaultPrefix } + "home" + queryString(List(if(email == null) None else Some(implicitly[QueryStringBindable[String]].unbind("email", email)), if(vfile == null) None else Some(implicitly[QueryStringBindable[String]].unbind("vfile", vfile)), if(dataset == null) None else Some(implicitly[QueryStringBindable[String]].unbind("dataset", dataset)))))
                                                        
// @LINE:28
case (email, vfile, dataset) if true => Call("GET", _prefix + { _defaultPrefix } + "climate" + queryString(List(if(email == null) None else Some(implicitly[QueryStringBindable[String]].unbind("email", email)), if(vfile == null) None else Some(implicitly[QueryStringBindable[String]].unbind("vfile", vfile)), if(dataset == null) None else Some(implicitly[QueryStringBindable[String]].unbind("dataset", dataset)))))
                                                        
   }
}
                                                

// @LINE:35
def deleteClimateService(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "climate/delete/climateServices")
}
                                                
    
}
                          
}
                  


// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:69
// @LINE:68
// @LINE:65
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:46
class ReverseAssets {
    

// @LINE:46
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:25
// @LINE:24
class ReverseAboutusController {
    

// @LINE:25
def aboutProject : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AboutusController.aboutProject",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "aboutProject"})
      }
   """
)
                        

// @LINE:24
def aboutUs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AboutusController.aboutUs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "aboutus"})
      }
   """
)
                        
    
}
              

// @LINE:65
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
class ReverseHomePageController {
    

// @LINE:59
def nextPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HomePageController.nextPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nextHomePage"})
      }
   """
)
                        

// @LINE:57
def homepage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HomePageController.homepage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "homepage"})
      }
   """
)
                        

// @LINE:65
def topPosts : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HomePageController.topPosts",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "topPosts"})
      }
   """
)
                        

// @LINE:62
def sharePost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HomePageController.sharePost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sharePost"})
      }
   """
)
                        

// @LINE:61
def commentPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HomePageController.commentPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "commentPost"})
      }
   """
)
                        

// @LINE:60
def likePost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HomePageController.likePost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "likePost"})
      }
   """
)
                        

// @LINE:58
def previousPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.HomePageController.previousPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "previousHomePage"})
      }
   """
)
                        
    
}
              

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseBugReportController {
    

// @LINE:17
def reports : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BugReportController.reports",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bugs"})
      }
   """
)
                        

// @LINE:21
def solveReport : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BugReportController.solveReport",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "solve/report"})
      }
   """
)
                        

// @LINE:20
def deleteReport : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BugReportController.deleteReport",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete/report"})
      }
   """
)
                        

// @LINE:19
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BugReportController.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bug/list"})
      }
   """
)
                        

// @LINE:18
def newReport : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.BugReportController.newReport",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newReport"})
      }
   """
)
                        
    
}
              

// @LINE:69
// @LINE:68
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
class ReverseMainPageController {
    

// @LINE:52
def nextPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.nextPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nextMainPage"})
      }
   """
)
                        

// @LINE:53
def createNewPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.createNewPost",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createNewPost"})
      }
   """
)
                        

// @LINE:54
def editPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.editPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editPost"})
      }
   """
)
                        

// @LINE:50
def mainpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.mainpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mainpage"})
      }
   """
)
                        

// @LINE:69
def searchPostsClick : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.searchPostsClick",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchPostsClick"})
      }
   """
)
                        

// @LINE:55
def deletePost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.deletePost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePost"})
      }
   """
)
                        

// @LINE:51
def previousPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.previousPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "previousMainPage"})
      }
   """
)
                        

// @LINE:68
def searchPosts : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainPageController.searchPosts",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchPosts"})
      }
   """
)
                        
    
}
              

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:12
def createNewUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.createNewUser",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createNewUser"})
      }
   """
)
                        

// @LINE:13
def createSuccess : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.createSuccess",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createSuccess"})
      }
   """
)
                        

// @LINE:14
def isEmailExisted : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.isEmailExisted",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "isEmailExisted"})
      }
   """
)
                        

// @LINE:11
def signup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.signup",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:10
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate"})
      }
   """
)
                        

// @LINE:8
// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
      }
   """
)
                        
    
}
              

// @LINE:74
// @LINE:73
// @LINE:72
class ReverseSearchController {
    

// @LINE:74
def addfollow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SearchController.addfollow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addfollow"})
      }
   """
)
                        

// @LINE:73
def searchUserClick : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SearchController.searchUserClick",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchUsersClick"})
      }
   """
)
                        

// @LINE:72
def searchUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SearchController.searchUser",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchUsers"})
      }
   """
)
                        
    
}
              

// @LINE:43
// @LINE:42
// @LINE:41
class ReverseDatasetController {
    

// @LINE:43
def getSearchResult : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.getSearchResult",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/getSearchResult"})
      }
   """
)
                        

// @LINE:42
def searchDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.searchDataset",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/searchDataSet"})
      }
   """
)
                        

// @LINE:41
def datasetList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.datasetList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/datasets"})
      }
   """
)
                        
    
}
              

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:6
class ReverseClimateServiceController {
    

// @LINE:38
def addClimateServices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.addClimateServices",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/new/climateServices"})
      }
   """
)
                        

// @LINE:31
def mostRecentlyAddedClimateServices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.mostRecentlyAddedClimateServices",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/mostRecentlyAddedClimateServices"})
      }
   """
)
                        

// @LINE:37
def editClimateService : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.editClimateService",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/edit/climateServices"})
      }
   """
)
                        

// @LINE:33
def mostPopularClimateServices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.mostPopularClimateServices",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/mostPopularClimateServices"})
      }
   """
)
                        

// @LINE:29
def tutorial : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.tutorial",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/tutorial"})
      }
   """
)
                        

// @LINE:39
def oneService : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.oneService",
   """
      function(url) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/oneService" + _qS([(url == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("url", url))])})
      }
   """
)
                        

// @LINE:36
def downloadClimateService : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.downloadClimateService",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/download/climateServices"})
      }
   """
)
                        

// @LINE:32
def mostRecentlyUsedClimateServices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.mostRecentlyUsedClimateServices",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/mostRecentlyUsedClimateServices"})
      }
   """
)
                        

// @LINE:30
def climateServices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.climateServices",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/climateServices"})
      }
   """
)
                        

// @LINE:34
def newClimateService : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.newClimateService",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/new/climateServices"})
      }
   """
)
                        

// @LINE:28
// @LINE:6
def home : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.home",
   """
      function(email, vfile, dataset) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home" + _qS([(email == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email)), (vfile == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("vfile", vfile)), (dataset == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("dataset", dataset))])})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climate" + _qS([(email == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email)), (vfile == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("vfile", vfile)), (dataset == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("dataset", dataset))])})
      }
      }
   """
)
                        

// @LINE:35
def deleteClimateService : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.deleteClimateService",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "climate/delete/climateServices"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:69
// @LINE:68
// @LINE:65
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:46
class ReverseAssets {
    

// @LINE:46
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:25
// @LINE:24
class ReverseAboutusController {
    

// @LINE:25
def aboutProject(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AboutusController.aboutProject(), HandlerDef(this, "controllers.AboutusController", "aboutProject", Seq(), "GET", """""", _prefix + """aboutProject""")
)
                      

// @LINE:24
def aboutUs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AboutusController.aboutUs(), HandlerDef(this, "controllers.AboutusController", "aboutUs", Seq(), "GET", """ About Us""", _prefix + """aboutus""")
)
                      
    
}
                          

// @LINE:65
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
class ReverseHomePageController {
    

// @LINE:59
def nextPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HomePageController.nextPage(), HandlerDef(this, "controllers.HomePageController", "nextPage", Seq(), "GET", """""", _prefix + """nextHomePage""")
)
                      

// @LINE:57
def homepage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HomePageController.homepage(), HandlerDef(this, "controllers.HomePageController", "homepage", Seq(), "GET", """Homepage""", _prefix + """homepage""")
)
                      

// @LINE:65
def topPosts(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HomePageController.topPosts(), HandlerDef(this, "controllers.HomePageController", "topPosts", Seq(), "GET", """top10Posts""", _prefix + """topPosts""")
)
                      

// @LINE:62
def sharePost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HomePageController.sharePost(), HandlerDef(this, "controllers.HomePageController", "sharePost", Seq(), "POST", """""", _prefix + """sharePost""")
)
                      

// @LINE:61
def commentPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HomePageController.commentPost(), HandlerDef(this, "controllers.HomePageController", "commentPost", Seq(), "POST", """""", _prefix + """commentPost""")
)
                      

// @LINE:60
def likePost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HomePageController.likePost(), HandlerDef(this, "controllers.HomePageController", "likePost", Seq(), "POST", """""", _prefix + """likePost""")
)
                      

// @LINE:58
def previousPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.HomePageController.previousPage(), HandlerDef(this, "controllers.HomePageController", "previousPage", Seq(), "GET", """""", _prefix + """previousHomePage""")
)
                      
    
}
                          

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseBugReportController {
    

// @LINE:17
def reports(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BugReportController.reports(), HandlerDef(this, "controllers.BugReportController", "reports", Seq(), "GET", """ BugReporting""", _prefix + """bugs""")
)
                      

// @LINE:21
def solveReport(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BugReportController.solveReport(), HandlerDef(this, "controllers.BugReportController", "solveReport", Seq(), "POST", """""", _prefix + """solve/report""")
)
                      

// @LINE:20
def deleteReport(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BugReportController.deleteReport(), HandlerDef(this, "controllers.BugReportController", "deleteReport", Seq(), "POST", """""", _prefix + """delete/report""")
)
                      

// @LINE:19
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BugReportController.list(), HandlerDef(this, "controllers.BugReportController", "list", Seq(), "GET", """""", _prefix + """bug/list""")
)
                      

// @LINE:18
def newReport(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.BugReportController.newReport(), HandlerDef(this, "controllers.BugReportController", "newReport", Seq(), "GET", """""", _prefix + """newReport""")
)
                      
    
}
                          

// @LINE:69
// @LINE:68
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
class ReverseMainPageController {
    

// @LINE:52
def nextPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.nextPage(), HandlerDef(this, "controllers.MainPageController", "nextPage", Seq(), "GET", """""", _prefix + """nextMainPage""")
)
                      

// @LINE:53
def createNewPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.createNewPost(), HandlerDef(this, "controllers.MainPageController", "createNewPost", Seq(), "GET", """""", _prefix + """createNewPost""")
)
                      

// @LINE:54
def editPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.editPost(), HandlerDef(this, "controllers.MainPageController", "editPost", Seq(), "POST", """""", _prefix + """editPost""")
)
                      

// @LINE:50
def mainpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.mainpage(), HandlerDef(this, "controllers.MainPageController", "mainpage", Seq(), "GET", """ profile
Mainpage""", _prefix + """mainpage""")
)
                      

// @LINE:69
def searchPostsClick(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.searchPostsClick(), HandlerDef(this, "controllers.MainPageController", "searchPostsClick", Seq(), "GET", """""", _prefix + """searchPostsClick""")
)
                      

// @LINE:55
def deletePost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.deletePost(), HandlerDef(this, "controllers.MainPageController", "deletePost", Seq(), "POST", """""", _prefix + """deletePost""")
)
                      

// @LINE:51
def previousPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.previousPage(), HandlerDef(this, "controllers.MainPageController", "previousPage", Seq(), "GET", """""", _prefix + """previousMainPage""")
)
                      

// @LINE:68
def searchPosts(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainPageController.searchPosts(), HandlerDef(this, "controllers.MainPageController", "searchPosts", Seq(), "GET", """searchPosts""", _prefix + """searchPosts""")
)
                      
    
}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:12
def createNewUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.createNewUser(), HandlerDef(this, "controllers.Application", "createNewUser", Seq(), "GET", """""", _prefix + """createNewUser""")
)
                      

// @LINE:13
def createSuccess(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.createSuccess(), HandlerDef(this, "controllers.Application", "createSuccess", Seq(), "GET", """""", _prefix + """createSuccess""")
)
                      

// @LINE:14
def isEmailExisted(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.isEmailExisted(), HandlerDef(this, "controllers.Application", "isEmailExisted", Seq(), "POST", """""", _prefix + """isEmailExisted""")
)
                      

// @LINE:11
def signup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.signup(), HandlerDef(this, "controllers.Application", "signup", Seq(), "GET", """""", _prefix + """signup""")
)
                      

// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:10
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "GET", """""", _prefix + """authenticate""")
)
                      

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          

// @LINE:74
// @LINE:73
// @LINE:72
class ReverseSearchController {
    

// @LINE:74
def addfollow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SearchController.addfollow(), HandlerDef(this, "controllers.SearchController", "addfollow", Seq(), "POST", """""", _prefix + """addfollow""")
)
                      

// @LINE:73
def searchUserClick(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SearchController.searchUserClick(), HandlerDef(this, "controllers.SearchController", "searchUserClick", Seq(), "GET", """""", _prefix + """searchUsersClick""")
)
                      

// @LINE:72
def searchUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SearchController.searchUser(), HandlerDef(this, "controllers.SearchController", "searchUser", Seq(), "GET", """searchUsers""", _prefix + """searchUsers""")
)
                      
    
}
                          

// @LINE:43
// @LINE:42
// @LINE:41
class ReverseDatasetController {
    

// @LINE:43
def getSearchResult(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DatasetController.getSearchResult(), HandlerDef(this, "controllers.DatasetController", "getSearchResult", Seq(), "GET", """""", _prefix + """climate/getSearchResult""")
)
                      

// @LINE:42
def searchDataset(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DatasetController.searchDataset(), HandlerDef(this, "controllers.DatasetController", "searchDataset", Seq(), "GET", """""", _prefix + """climate/searchDataSet""")
)
                      

// @LINE:41
def datasetList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DatasetController.datasetList(), HandlerDef(this, "controllers.DatasetController", "datasetList", Seq(), "GET", """Keyword search""", _prefix + """climate/datasets""")
)
                      
    
}
                          

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:6
class ReverseClimateServiceController {
    

// @LINE:38
def addClimateServices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.addClimateServices(), HandlerDef(this, "controllers.ClimateServiceController", "addClimateServices", Seq(), "GET", """""", _prefix + """climate/new/climateServices""")
)
                      

// @LINE:31
def mostRecentlyAddedClimateServices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.mostRecentlyAddedClimateServices(), HandlerDef(this, "controllers.ClimateServiceController", "mostRecentlyAddedClimateServices", Seq(), "GET", """""", _prefix + """climate/mostRecentlyAddedClimateServices""")
)
                      

// @LINE:37
def editClimateService(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.editClimateService(), HandlerDef(this, "controllers.ClimateServiceController", "editClimateService", Seq(), "POST", """""", _prefix + """climate/edit/climateServices""")
)
                      

// @LINE:33
def mostPopularClimateServices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.mostPopularClimateServices(), HandlerDef(this, "controllers.ClimateServiceController", "mostPopularClimateServices", Seq(), "GET", """""", _prefix + """climate/mostPopularClimateServices""")
)
                      

// @LINE:29
def tutorial(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.tutorial(), HandlerDef(this, "controllers.ClimateServiceController", "tutorial", Seq(), "GET", """""", _prefix + """climate/tutorial""")
)
                      

// @LINE:39
def oneService(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.oneService(url), HandlerDef(this, "controllers.ClimateServiceController", "oneService", Seq(classOf[String]), "GET", """""", _prefix + """climate/oneService""")
)
                      

// @LINE:36
def downloadClimateService(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.downloadClimateService(), HandlerDef(this, "controllers.ClimateServiceController", "downloadClimateService", Seq(), "POST", """""", _prefix + """climate/download/climateServices""")
)
                      

// @LINE:32
def mostRecentlyUsedClimateServices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.mostRecentlyUsedClimateServices(), HandlerDef(this, "controllers.ClimateServiceController", "mostRecentlyUsedClimateServices", Seq(), "GET", """""", _prefix + """climate/mostRecentlyUsedClimateServices""")
)
                      

// @LINE:30
def climateServices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.climateServices(), HandlerDef(this, "controllers.ClimateServiceController", "climateServices", Seq(), "GET", """""", _prefix + """climate/climateServices""")
)
                      

// @LINE:34
def newClimateService(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.newClimateService(), HandlerDef(this, "controllers.ClimateServiceController", "newClimateService", Seq(), "POST", """""", _prefix + """climate/new/climateServices""")
)
                      

// @LINE:6
def home(email:String, vfile:String, dataset:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.home(email, vfile, dataset), HandlerDef(this, "controllers.ClimateServiceController", "home", Seq(classOf[String], classOf[String], classOf[String]), "GET", """ Home page""", _prefix + """home""")
)
                      

// @LINE:35
def deleteClimateService(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ClimateServiceController.deleteClimateService(), HandlerDef(this, "controllers.ClimateServiceController", "deleteClimateService", Seq(), "POST", """""", _prefix + """climate/delete/climateServices""")
)
                      
    
}
                          
}
        
    