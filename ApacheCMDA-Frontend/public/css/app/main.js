/**
 * Created by lixunrong on 11/17/15.
 */
$(document).ready(function() {

    autoComplete();
    filterPost();

    commentPost();
    likePost();
    sharePost();
    morePosts();
})

function prepAutoCompleteUser() {
    return $.ajax({
        url: "/sns/autocomplete/users",
        type: "GET"
    });
}

function filterPost() {
    var posts = $(".panel.panel-white.post.panel-shadow");
    var hiddenPosts = [];

    $("#srch-term").on('input',function() {
        var keyword = $(this).val();
        console.log(keyword);
        if(keyword == "" || keyword == null) {
            hiddenPosts.forEach(function(item) {
                if($(item).is(":hidden")) {
                    $(item).show();
                }
            });
        } else {
            posts.each(function(index, item) {
                var content = $(item).find(".post-description").text();
                if(content.indexOf(keyword) == -1) {
                    //hidden unrelated posts
                    $(item).hide();
                    hiddenPosts.push(item);
                } else {
                    $(item).show();
                }
            })
        }
    })

}

function autoComplete() {
    var deferred = prepAutoCompleteUser();

    $.when(deferred).done(function(data) {

        var allUsers = [];
        var allFirstNames = [];
        var allLastNames = [];
        var allAffiliations = [];
        var allEmails = [];

        data.forEach(function(item) {
            allUsers.push({
                id: item.id,
                label: item.userName,
                value: item.userName,
                desc: item.firstName + " " + item.lastName,
                origin: "user"
            });

            allFirstNames.push({
                label: item.firstName,
                value: item.firstName
            });

            allLastNames.push({
                label: item.lastName,
                value: item.lastName
            });

            allAffiliations.push({
                label: item.affiliation,
                value: item.affiliation
            })

            allEmails.push({
                label: item.researchInterests,
                value: item.researchInterests
            })
        })

        $("#fuzzy-search-input").autocomplete({
            source: allUsers,
            minLength: 1,
            appendTo: "#searchUserModal"
        }).data("ui-autocomplete")._renderItem = function(ul, item) {
            return $("<li>").data("item.autocomplete", item).append(
                "<a><strong>" + item.label
                + "</strong><br>" + item.desc + "</a>").appendTo(ul);
        }

        $("#firstName-input").autocomplete({
            source: allFirstNames,
            minLength: 1,
            appendTo: "#searchUserModal"
        }).data("ui-autocomplete")._renderItem = function(ul, item) {
            return $("<li>").data("item.autocomplete", item).append(
                "<a><strong>" + item.label + "</strong></a>").appendTo(ul);
        }

        $("#lastName-input").autocomplete({
            source: allLastNames,
            minLength: 1,
            appendTo: "#searchUserModal"
        }).data("ui-autocomplete")._renderItem = function(ul, item) {
            return $("<li>").data("item.autocomplete", item).append(
                "<a><strong>" + item.label + "</strong></a>").appendTo(ul);
        }

        $("#affiliation-input").autocomplete({
            source: allAffiliations,
            minLength: 1,
            appendTo: "#searchUserModal"
        }).data("ui-autocomplete")._renderItem = function(ul, item) {
            return $("<li>").data("item.autocomplete", item).append(
                "<a><strong>" + item.label + "</strong></a>").appendTo(ul);
        }

        $("#email-input").autocomplete({
            source: allEmails,
            minLength: 1,
            appendTo: "#searchUserModal"
        }).data("ui-autocomplete")._renderItem = function(ul, item) {
            return $("<li>").data("item.autocomplete", item).append(
                "<a><strong>" + item.label + "</strong></a>").appendTo(ul);
        }
    })
}

function commentPost() {

    var userId = $("#hiddenUserId").val();
    var userName = $("#hiddenUserName").val();

    //click comment to slide down
    $(".comment-btn").click(function() {
        var post = $(this).closest(".post");
        var comment = $(post).find(".post-footer");

        if ($(comment).is(':hidden')) {
            $(comment).slideDown(400);
        } else {
            $(comment).slideUp(400);
        }
    })


    //submit comment
    $(".submit-comment").click(function() {
        var comment = $(this).closest(".post-footer");
        var id = $(this).attr('id').split('-')[1];
        var content = $(this).parent().prev("input.form-control");
        var text = content.val();

        var obj = {
            content: text,
            postId: id
        }

        //send ajax request to create new comment
        $.ajax({
            url: "/sns/posts/newComment",
            type: "POST",
            data: JSON.stringify(obj),
            headers: {
                'Content-Type': 'application/json'
            }
        }).done(function(data) {

            content.val("");
            //display the comment on the screen
            var list = $(comment).find("ul.comments-list");
            var dt = new Date();
            var time = dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds();

            $(list).prepend(
                '<li class="comment"> <a class="pull-left" href="#">' +
                '<img class="avatar" src="http://localhost:9034/users/getPhoto/' + userId +'" alt="avatar"> </a>' +
                '<div class="comment-body"> <div class="comment-heading"> <h4 class="user">'+ userName + '</h4>' +
                '<h5 class="time">' + time + '</h5> </div>' +
                '<p>' + text + '</p> </div> </li>'
            )

        }).error(function(error) {
            console.log(error);
        })
    })
}

function likePost() {
    //click like
    $(".like-btn").click(function() {
        var post = $(this).closest(".post");
        var id = $(post).attr('id').split('-')[1];
        var likeCount = $(this).text();
        likeCount++;

        var that = $(this);

        $.ajax({
            url: "/sns/posts/newLike",
            type: "POST",
            data: JSON.stringify({
                postId: id
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).done(function(data) {

            $(that).html(
                '<i class="fa fa-thumbs-up icon"></i>' + likeCount
            );

        }).error(function(error) {
            console.log(error);
        })
    })
}

function sharePost() {
    //click share
    $(".share-btn").click(function() {
        var post = $(this).closest(".post");
        var id = $(post).attr('id').split('-')[1];
        var shareCount = $(this).text();
        shareCount++;
        var that = $(this);

        $.ajax({
            url: "/sns/posts/newShare",
            type: "POST",
            data: JSON.stringify({
                postId: id
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).done(function(data) {
            $(that).html(
                '<i class="fa fa-share icon"></i>' + shareCount
            );

        }).error(function(error) {
            console.log(error);
        })
    })
}

function morePosts() {
    //click more btn
    $(".more-btn").click(function() {
        $(this).hide();
        var posts = $(".container.bootstrap.snippet");
        posts.each(function() {
            if ($(this).is(':hidden')) {
                $(this).show();
            }
        })
    })
}

function getFile(){
    $("#upfile").click();
    //e.preventDefault();
}

function sub(obj){
    if (obj.files && obj.files[0]) {
        var reader = new FileReader();

        console.log("ready to submit");

        var image = obj.files[0];
        var userId = $("#hiddenSession").val();
        var formData = new FormData($('#profile-image-form')[0]);

        console.log("ajax");
        $.ajax({
            url: "http://localhost:9034/users/uploadPhoto/" + userId,
            type: "POST",
            data: formData,
            //Options to tell jQuery not to process data or worry about content-type.
            cache: false,
            contentType: false,
            processData: false
        }).done(function(data) {
            console.log(data);
        }).error(function(err) {
            console.log(err);
        });


        reader.onload = function (e) {
            $(".profile-image").css('background-image', 'url(' + e.target.result + ')');
        }

        reader.readAsDataURL(obj.files[0]);
    }
}



