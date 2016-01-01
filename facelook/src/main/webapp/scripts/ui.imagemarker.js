/**
 * 该Javascript UI库是基于jQuery的扩展。
 * @version #1.0.0 2009-12
 * Depend on jQuery 1.3.x , jQuery ui core,jquery ui dragdrop,jquery ui resize
 */
if (typeof xuanchi === 'undefined')
    var xuanchi = {};
if (typeof xuanchi.ui === 'undefined')
    xuanchi.ui = {};
 (function($jj){
	xuanchi.ui.imageMarker = function(){
		
	};
	 xuanchi.ui.imageMarker = function(options) {
        this.opts = $jj.extend({}, xuanchi.ui.imageMarker.defaults, options, true);
        this.id = "photo-marker"
        this._init();
        this.friendSuggest = null;
    };
    xuanchi.ui.imageMarker.prototype = {
        _init:function() {
            this._getTemp();
			this._eventBind();
        },
        _getTemp:function() {
            var str = '<div class="photo-marker" id="' + this.id + '"><div class="frame"></div><span class="t"></span><span class="r"></span><span class="b"></span><span class="l"></span><div class="okPosition">标注：<input type="text" maxlength="10" /><div class="okFre"></div><button type="button">确定</button><button type="button" class="button">取消</button></div></div>';
			if ($jj("#photo-marker").length==0){$jj(str).appendTo($jj(this.opts.bigImageContainer));}
            this.$marker =  $jj("#"+this.id); 
        },
        _eventBind:function() {
            var _this = this;
            this.$marker.draggable({
                containment:"parent",
                drag:function(){
               	  _this._resize();
				  if($jj.isFunction(_this.opts.drag)){
					 _this.opts.drag.call(_this);
				  }
				  $jj(".okPosition").slideUp("fast");
               },
               stop:function(){
               	  _this._resize();
				  if($jj.isFunction(_this.opts.dragStop)){
					 _this.opts.dragStop.call(_this);
				  }
				  $jj(".okPosition").slideDown("fast");
               }
            });
            this.$marker.resizable({
                handles:"n,e,s,w,se,sw,ne,nw",
                minHeight:30,
                minWidth:30,
                resize:function(event,ui) {
                    _this._resize();
					if($jj.isFunction(_this.opts.resize)){
						_this.opts.resize.call(_this);
					}
                },
                stop:function(){
                	_this._resize();
					if($jj.isFunction(_this.opts.risizeStop)){
					 _this.opts.risizeStop.call(_this);
					}
                }
            });
        },
        _resize:function(){
        	var _this = this;
        	var left = _this.$marker.position().left;
            var top = _this.$marker.position().top;
            var width = _this.$marker.outerWidth(true);
            var height = _this.$marker.outerHeight(true);
            var imgWidth = $jj(_this.opts.bigImage).outerWidth(true);
            var imgHeight = $jj(_this.opts.bigImage).outerHeight(true);
            if(left<0){
                _this.$marker.css("left",0);
            }
            if(top<0){
                _this.$marker.css("top",0);
            }
            if(left+width>imgWidth){
                _this.$marker.css("width",imgWidth-left+"px");
            }
            if(top+height>imgHeight){
                _this.$marker.css("height",imgHeight-top+"px");
            }
        },
        saveMarker:function(){
   
        },
        remove:function(){
        	this.$marker.remove();
        	$jj("#album-friend-wapper").remove();
        },
        /*获取当前圈人定位*/
        getPosition:function(){
            return{
                nw:[this.$marker.position().left,this.$marker.position().top],
                se:[this.$marker.position().left+this.$marker.width(),this.$marker.position().top+this.$marker.height()]
            }
        }
    };
	xuanchi.ui.imageMarker.defaults = {
       bigImageContainer:"#imgContainer",
	   bigImage:"#bigImage",
	   drag:null,
	   resize:null,
	   dragStop:null,
	   resizeStrop:null
	}
 })(jQuery);