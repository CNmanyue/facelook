function showTags(){
	photo=window.eval(photo);
	if ($jj(".divArr").length==0){
		$jj('<div class="divArr"></div>').
		appendTo($jj("#imgContainer"));
	}
	var listTags="";
	var listDivs="";
	if(photo.length>0){
		for(var i=0;i<photo.length;i++){
			listTags+="<li id=\""+photo[i].taguserid+"\">"+photo[i].tagname+" <span id=\""+photo[i].tagid+"\">脳</span></li>";
			listDivs+="<div style=\"height:"+(photo[i].rightT-photo[i].leftT)+"px;width:"+(photo[i].rightL-photo[i].leftL)+"px;"
			listDivs+="left:"+photo[i].leftL+"px;top:"+photo[i].leftT+"px;\" title=\""+photo[i].tagname+"\"></div>"
		}
		$jj(".divArr").html(listDivs);
		$jj("#imgSide").html("<ul>"+listTags+"</ul>");
		$jj("#imgSide").find("ul > li").each(function(k){
			$jj(this).mouseover(function(){
				XC.divShow(k);
			}).
			mouseout(function(){
				XC.divHide(k);
			}).
			click(function(){
				XC.goSpace($jj(this).attr("id"));
			}).
			children("span").click(function(){
				XC.delDiv($jj(this).attr("id"));
			});
		});$jj(".divArr").find("div").each(function(k){
			$jj(this).addClass("divShow").
			attr("id","div_"+k).
			css("z-index",999+k).
			mouseover(function(){
				$jj(this).
				css({ border: "1px #FF6600 solid",
				height: ""+(parseInt($jj(this).css("height"))-2)+"px",
				width: ""+(parseInt($jj(this).css("width"))-2)+"px" }).
				html("<div style=\"top:"+(parseInt($jj(this).css("height"))+2)+"px;left:"+$jj(this).css("left")+"px;\" class=\"divHtml\">"+$jj(this).attr("title")+"</div>");
			}).
			mouseout(function(){
				$jj(this).
				css({ border: "0px #FF6600 solid",
				height: ""+(parseInt($jj(this).css("height"))+2)+"px",
				width: ""+(parseInt($jj(this).css("width"))+2)+"px" }).
				children("div").
				remove();
			});
		});
	}
}

showTags.prototype = {
    divShow: function (div) {
		$jj("#div_"+div).
		css({ border: "1px #FF6600 solid",
		height: ""+(parseInt($jj("#div_"+div).css("height"))-2)+"px",
		width: ""+(parseInt($jj("#div_"+div).css("width"))-2)+"px" }).
		html("<div style=\"top:"+(parseInt($jj("#div_"+div).css("height"))+2)+"px;left:"+$jj("#div_"+div).css("left")+"px;\" class=\"divHtml\">"+$jj("#div_"+div).attr("title")+"</div>");
    },
    divHide: function (div) {
		$jj("#div_"+div).
		css({ border: "0px #FF6600 solid",
		height: ""+(parseInt($jj("#div_"+div).css("height"))+2)+"px",
		width: ""+(parseInt($jj("#div_"+div).css("width"))+2)+"px" }).
		children("div").
		remove();
    },
	alldivHide: function () {
		$jj(".divShow").hide();
	},
	alldivShow: function () {
		$jj(".divShow").show();
	},
	goSpace: function (uID) {
		// if(uID!="")alert(uID);
	},
	delDiv: function (tID) {
		// ajax鍒犻櫎tag
		XC=new showTags();
		$jj("#photo-marker").fadeOut("slow",
		function(){
			$jj(".okPosition").
			slideUp("slow");
		});
	}
}

var XC=new showTags();

var code_00="@";
var arrLenn="@";
var firstVall="";
function frSearch(){
$jj(".okPosition").children("input").val($jj(".okPosition").children("input").val().replace(/[,'"\\&<>?()%$#@!^*_+-;~]/g,""));
$jj(".okPosition").children("input").val($jj(".okPosition").children("input").val().replace(/\s/,""));
var code=$jj(".okPosition").children("input").val();
	if(code!=""){
		if(code.indexOf(code_00)==-1 || arrLenn!=0){
			if(firstVall!=code){
				$jj.ajax({
					type    : "GET" ,
					async   : false ,
					url     : "api.txt",
					data    : "ran="+Math.random()+"&key="+code,
					success : function(msg){
						if(msg.indexOf("鎮ㄥ凡鐧诲綍瓒呮椂")==-1){
							var jsonFr=window.eval(msg);
							var listFrr="";
							if(jsonFr.length!=0){
								for(i=0;i<jsonFr.length;i++){
									listFrr+="<input type=\"radio\" value=\""+jsonFr[i].USERID+"\" name=\"jsonFr\" class=\"radio\" /> "+jsonFr[i].USERNAME+" ("+jsonFr[i].REGION+")<br />";
								}
								$jj(".okFre").html("<b>鎮ㄤ篃鍙互鐩存帴閫夋嫨浠ヤ笅濂藉弸:</b><br />"+listFrr);
								arrLenn=jsonFr.length;
								code_00="@";
								firstVall=code;
							}else{
								/* 娌℃湁鎵惧埌鍖归厤鏈嬪弸 */
								arrLenn=0;
								firstVall="";
								code_00=="@"?code_00=code:code_00="@";
							}
						}else{
							/* 鐧诲綍瓒呮椂 */
							arrLenn=0;
						}
					} ,
					error   : function(){
						/* 缃戠粶绻佸繖,璇锋眰澶辫触 */
						arrLenn=0;
					}
				});
			}
		}else{
			/*
			 * 鏈壘鍒板尮閰嶆湅鍙�/ firstVall=""; arrLenn=0; } }else{ /*鏈緭鍏ュ瓧姣嶆垨姹夊瓧
			 */
		firstVall="";
		arrLenn=0;
	}
	if(arrLenn==0){
		$jj(".okFre").css({ height: "1px", overflow: "hidden" }); 
	}else{
		$jj(".okFre").children("input").each(function(k){
			$jj(this).click(function(){
				// ajax鎻愪氦濂藉弸
				var myObj =  imagemarker.getPosition();
				alert("ID:"+ this.value + "宸叉彁浜わ紝宸︿笂Left:"+ myObj.nw[0] + "; 宸︿笂Top:" + myObj.nw[1] + "; 鍙充笅Left:" + myObj.se[0] + "; 鍙充笅Top:" + myObj.se[1]);
				XC=new showTags();
				quanren = false;
				$jj("#photo-marker").
				remove();
			});
		});
		$jj(".okFre").css("height","auto");
	}
	$jj(".okFre").slideDown("slow");
}
/**/
var imagemarker = null;
var quanren = false;
$jj("#quanren").click(function(){
	if(!quanren){
		imagemarker = new xuanchi.ui.imageMarker({
			drag:test,
			resize:test,
			dragStop:test,
			resizeStrop:test
		});
	}
	quanren = true;
	XC.alldivHide();
	$jj("#photo-marker").slideDown("slow",
		function(){
		$jj(".okPosition").slideDown("slow",function(){
			$jj(this).children("input").keyup(function(){
				frSearch();
			});
			$jj(this).children("button").each(function(k){
				if(k==0){$jj(this).click(function(){
					// ajax鎻愪氦
					
					XC=new showTags();
					quanren = false;
					$jj("#photo-marker").
					remove();
				});}
				if(k==1){$jj(this).click(function(){
					if(quanren){
						quanren = false;
						XC.alldivShow();
						$jj("#photo-marker").fadeOut("slow",
						function(){
							$jj(".okPosition").
							slideUp("slow");
						});
					}
				});}
			});
		});
	});
});

function test(){
	var myObj =  imagemarker.getPosition();
	$jj(".okPosition").css({ top: 0, left: myObj.se[0]-myObj.nw[0]+6 }); 
}}