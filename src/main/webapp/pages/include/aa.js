/*
 * ! Bootstrap.base.js by @fat & @mdo Copyright 2012 Twitter, Inc.
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 */
$().ready(function() {
	function fix_position() {
		var e = $("#user-nav > ul").width();
		$("#user-nav > ul").css({
					width : e,
					"margin-left" : "-" + e / 2 + "px"
				});
		var t = $("#content-header .btn-group").width();
		$("#content-header .btn-group").css({
					width : t,
					"margin-left" : "-" + e / 2 + "px"
				})
	}
	var locationUrl = document.location.href, menuId = "", resourceId = "";
	$.initLeftMenu = function() {
		$.ajax({
			url : "../menu/left_menu.do",
			data : {
				time : (new Date).getTime()
			},
			type : "POST",
			dataType : "json",
			async : !1,
			cache : !1,
			success : function(e) {
				var t = "";
				$.each(e, function(e, n) {
					t += '<li id="' + n.id + '" class="submenu">', t += '<a href="#">', t += '<i class="icon '
							+ n.iconClass + '"></i> ', t += "<span>" + n.name
							+ '</span> <span class="label label-important">'
							+ n.resourceList.length + "</span>", t += "</a>", t += "<ul>", $
							.each(n.resourceList, function(e, n) {
								locationUrl.indexOf(n.path) > 0
										&& (resourceId = n.id, menuId = n.menuId), t += ' <li id="'
										+ n.id
										+ '"><a href="../..'
										+ n.path
										+ '">' + n.name + "</a></li>"
							}), t += "</ul>", t += "</li>"
				}), $("#leftMenuList").html(t)
			},
			error : function() {
				$.showMsg({
							type : "error",
							title : "\u63d0\u793a",
							message : "\u7f51\u7edc\u5f02\u5e38"
						})
			}
		})
	}(), $(".submenu > a").click(function(e) {
		e.preventDefault();
		var t = $(this).siblings("ul"), n = $(this).parents("li"), r = $("#sidebar li.submenu ul"), i = $("#sidebar li.submenu");
		n.hasClass("open") ? ($(window).width() > 768
				|| $(window).width() < 479 ? t.slideUp() : t.fadeOut(250), n
				.removeClass("open")) : ($(window).width() > 768
				|| $(window).width() < 479 ? (r.slideUp(), t.slideDown()) : (r
				.fadeOut(250), t.fadeIn(250)), i.removeClass("open"), n
				.addClass("open"))
	});
	var ul = $("#sidebar > ul");
	$("#sidebar > a").click(function(e) {
		e.preventDefault();
		var t = $("#sidebar");
		t.hasClass("open") ? (t.removeClass("open"), ul.slideUp(250)) : (t
				.addClass("open"), ul.slideDown(250))
	}), $("#" + menuId).addClass("open"), $("#" + resourceId)
			.addClass("active"), $(window).resize(function() {
		$(window).width() > 479 && (ul.css({
					display : "block"
				}), $("#content-header .btn-group").css({
					width : "auto"
				})), $(window).width() < 479 && (ul.css({
					display : "none"
				}), fix_position()), $(window).width() > 768
				&& ($("#user-nav > ul").css({
							width : "auto",
							margin : "0"
						}), $("#content-header .btn-group").css({
							width : "auto"
						}))
	}), $(window).width() < 468 && (ul.css({
				display : "none"
			}), fix_position()), $(window).width() > 479
			&& ($("#content-header .btn-group").css({
						width : "auto"
					}), ul.css({
						display : "block"
					})), $(".tip").tooltip(), $(".tip-left").tooltip({
				placement : "left"
			}), $(".tip-right").tooltip({
				placement : "right"
			}), $(".tip-top").tooltip({
				placement : "top"
			}), $(".tip-bottom").tooltip({
				placement : "bottom"
			}), $("#search input[type=text]").typeahead({
		source : ["Dashboard", "Form elements", "Common Elements",
				"Validation", "Wizard", "Buttons", "Icons",
				"Interface elements", "Support", "Calendar", "Gallery",
				"Reports", "Charts", "Graphs", "Widgets"],
		items : 4
	}), $("#style-switcher i").click(function() {
		$(this).hasClass("open") ? ($(this).parent().animate({
					marginRight : "-=190"
				}), $(this).removeClass("open")) : ($(this).parent().animate({
					marginRight : "+=190"
				}), $(this).addClass("open")), $(this)
				.toggleClass("icon-arrow-left"), $(this)
				.toggleClass("icon-arrow-right")
	}), $("#style-switcher a").click(function() {
		var e = $(this).attr("href").replace("#", "");
		$(".skin-color").attr("href", "css/maruti." + e + ".css"), $(this)
				.siblings("a").css({
							"border-color" : "transparent"
						}), $(this).css({
					"border-color" : "#aaaaaa"
				})
	}), $(".lightbox_trigger").click(function(e) {
		e.preventDefault();
		var t = $(this).attr("href");
		if ($("#lightbox").length > 0)
			$("#imgbox").html('<img src="' + t
					+ '" /><p><i class="icon-remove icon-white"></i></p>'), $("#lightbox")
					.slideDown(500);
		else {
			var n = '<div id="lightbox" style="display:none;"><div id="imgbox"><img src="'
					+ t
					+ '" />'
					+ '<p><i class="icon-remove icon-white"></i></p>'
					+ "</div>" + "</div>";
			$("body").append(n), $("#lightbox").slideDown(500)
		}
	}), $("#lightbox").bind("click", function() {
				$("#lightbox").hide(200)
			}), $.showMsg = function(e) {
		$.msgGrowl({
					type : e.type,
					title : e.title,
					text : e.message
				})
	}, $.alert = function(e) {
		"error" == e.type ? $.msgbox(e.message, {
					type : e.type
				}) : "info" == e.type ? $.msgbox(e.message, {
					type : e.type
				}) : "warning" == e.type && $.msgbox(e.message)
	}, $.confirm = function(e) {
		$.msgbox(e.message, {
					type : "confirm",
					buttons : [{
								type : "submit",
								value : "\u786e\u5b9a"
							}, {
								type : "cancel",
								value : "\u53d6\u6d88"
							}]
				}, function(t) {
					switch (t) {
						case "\u786e\u5b9a" :
							e.submit();
							break;
						case !1 :
							e.cancel()
					}
				})
	}, $.initTHSelect = function() {
		$("#th-checkbox-select").uniform(), $("select").select2(), $("span.icon input:checkbox, th input:checkbox")
				.click(function() {
					var e = this.checked, t = $(this).parents(".widget-box")
							.find("tr td:first-child input:checkbox");
					t.each(function() {
								this.checked = e, e == this.checked
										&& $(this).closest(".checker > span")
												.removeClass("checked"), this.checked
										&& $(this).closest(".checker > span")
												.addClass("checked")
							})
				})
	}, $.initTDSelect = function() {
		$(".td-checkbox-select").uniform(), $("select").select2()
	}, $.clearSelect = function() {
		$("input[name='title-table-checkbox']").attr("checked", !1);
		var e = $("input[name='title-table-checkbox']");
		e.length > 0 && $(e[0].parentNode).removeClass("checked")
	}, $.initSelect = function(e) {
		$(e).uniform(), $("select").select2()
	}, $.deleteData = function(e) {
		var t = new Array, n = $("input[name='id-checkbox']:checked");
		$.each(n, function(e, n) {
					t.push(n.value)
				});
		if (t.length <= 0) {
			$.showMsg({
				type : "warning",
				title : "\u63d0\u793a",
				message : "\u8bf7\u9009\u62e9\u8981\u5220\u9664\u7684\u8bb0\u5f55"
			});
			return
		}
		$.confirm({
			message : "\u662f\u5426\u8981\u5220\u9664\u9009\u4e2d\u6570\u636e",
			submit : function() {
				$.ajax({
					url : e.url,
					data : JSON.stringify(t),
					type : "POST",
					dataType : "json",
					contentType : "application/json; charset=utf-8",
					cache : !1,
					success : function(t) {
						t.success ? ($.clearSelect(), e.callback(), $.showMsg({
									type : "success",
									title : "\u63d0\u793a",
									message : "\u6570\u636e\u5220\u9664\u6210\u529f"
								}))
								: $.showMsg({
									type : "error",
									title : "\u63d0\u793a",
									message : "\u6570\u636e\u5220\u9664\u5931\u8d25"
								})
					},
					error : function() {
						$.showMsg({
									type : "error",
									title : "\u63d0\u793a",
									message : "\u7f51\u7edc\u5f02\u5e38"
								})
					}
				})
			},
			cancel : function() {
			}
		})
	}, $.saveData = function(e) {
		if (!$("#" + e.id).valid())
			return !1;
		$.ajax({
					url : e.url,
					data : $("#" + e.id).serialize(),
					type : "POST",
					dataType : "json",
					cache : !1,
					success : function(t) {
						t.success ? (e.callback(), $.showMsg({
									type : "success",
									title : "\u63d0\u793a",
									message : t.content
								})) : $.showMsg({
									type : "error",
									title : "\u63d0\u793a",
									message : t.content
								})
					},
					error : function() {
						$.showMsg({
									type : "error",
									title : "\u63d0\u793a",
									message : "\u7f51\u7edc\u5f02\u5e38"
								})
					}
				})
	}, $.updateData = function(e) {
		if (!$("#" + e.id).valid())
			return !1;
		$.ajax({
					url : e.url,
					data : $("#" + e.id).serialize(),
					type : "POST",
					dataType : "json",
					cache : !1,
					success : function(t) {
						t.success ? (e.callback(), $.showMsg({
									type : "success",
									title : "\u63d0\u793a",
									message : t.content
								})) : $.showMsg({
									type : "error",
									title : "\u63d0\u793a",
									message : t.content
								})
					},
					error : function() {
						$.showMsg({
									type : "error",
									title : "\u63d0\u793a",
									message : "\u7f51\u7edc\u5f02\u5e38"
								})
					}
				})
	}, $.createTable = function(e) {
		var t = {
			sTitle : "<input type='checkbox' id='th-checkbox-select' name='title-table-checkbox' />",
			mData : "id",
			mRender : function(e, t, n) {
				var r = "";
				return r += '<div id="uniform-' + e + '">', r += "	<span>", r += '		<input type="checkbox" name="id-checkbox" class="td-checkbox-select" value="'
						+ e + '" style="opacity: 0;">', r += "	</span>", r += "</div>", r
			}
		}, n = new Array;
		n.push(t), n = n.concat(e.columns);
		var r = $("#" + e.id).dataTable({
					bPaginate : !0,
					bAutoWidth : !1,
					bProcessing : !0,
					bFilter : !0,
					bJQueryUI : !0,
					bServerSide : !0,
					bSort : !1,
					aaSorting : [[e.orderIndex, e.orderType]],
					sPaginationType : "full_numbers",
					sServerMethod : "POST",
					sAjaxSource : e.url,
					aoColumns : n,
					fnDrawCallback : $.initTDSelect,
					fnServerParams : e.filter
				});
		return $.initTHSelect(), r
	}, $.validate = function(e) {
		var t = $("#" + e.id).validate({
			rules : e.rules,
			messages : e.messages,
			errorClass : "help-inline",
			focusInvalid : !1,
			onkeyup : !1,
			errorElement : "span",
			highlight : function(e, t, n) {
				$(e).parents(".control-group").removeClass("success"), $(e)
						.parents(".control-group").addClass("error")
			},
			unhighlight : function(e, t, n) {
				$(e).parents(".control-group").removeClass("error"), $(e)
						.parents(".control-group").addClass("success")
			}
		});
		return t
	}, $.setValues = function(e) {
		var t = $("#" + e.id)[0];
		for (var n in e.data) {
			var r = e.data[n], i = $(t[n = n]);
			if (i != null && i.length > 0)
				if (i[0].nodeName == "INPUT") {
					var s = $(t[n = n]).attr("type");
					s == "text" || s == "select-one" || s == "hidden"
							|| s == "button"
							? $(t[n = n]).val(r)
							: s == "radio" ? $(t[n = n][r = r]).attr("checked",
									"checked") : s == "checkbox"
									&& $(t[n = n]).attr("checked", r)
				} else if (i[0].nodeName == "TEXTAREA")
					$(t[n = n]).val(r);
				else if (i[0].nodeName == "SELECT") {
					var o = $(t[n = n]);
					$("#" + o[0].id).select2("val", r)
				}
		}
	}, $.resetForm = function(e) {
		$("#" + e.id + " div").removeClass("error"), $("#" + e.id + " div")
				.removeClass("success"), $("#" + e.id)[0].reset(), $("#" + e.id)
				.validate().resetForm()
	}, $.ajaxSubmit = function(options) {
		var async = !1;
		options.async && (async = options.async);
		var xmlhttp = new XMLHttpRequest;
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var data = eval("(" + xmlhttp.responseText + ")");
				options.success(data)
			}
		}, xmlhttp.open("POST", options.url, async), xmlhttp
				.send(new FormData(document.getElementById(options.id)))
	}
})