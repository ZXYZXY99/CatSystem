

$(document).ready(function () {
    // $(".mian_bottom").animate({top: "-=120"}, 2000);
    $(".mian_bottom").fadeIn(2000);



    $(".wenzz").waypoint(function() {
        $(".wenzz_timu").fadeIn(1000);
    }, { offset:"60%"});

    $(".wenzz").waypoint(function () {
        $(".wenzz_wenben").fadeIn(1000);
    }, {offset:"20%"});

    $(".hei").waypoint(function () {
        $(".hei_zi").fadeIn(1000);
    }, {offset:"60%"});
});


function tiao() {
    $("input[name=show]").click(function () {
        $('html,body').animate({scrollTop:1000},'slow');
    })
}

function backtop() {
    $(".backtop").click(function () {
        $('html,body').animate({scrollTop:0},'slow');
    })
}











