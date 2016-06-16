$(document).ready(function() {
		$("input[name='learnedStatus']").click(function() {
			var selectedCategory = $("#selectedCategory").val();
			var learnedStatus = $("input[name='learnedStatus']:checked").val();
			$.ajax({
				url : 'filterAction.action',
				type : 'post',
				data : {'selectedCategory':selectedCategory,'learnedStatus':learnedStatus},
				dataType : 'json',
				success : function(result) {
					$("#body-content").empty();
					for( j = 0; j < result["listWordCategory"].length; j++ ){					
						d = document.createElement('div');
						$(d).addClass("body-left").html(result["listWordCategory"][j].contentResult).appendTo($("#body-content"))
						d1 = document.createElement('div');
						$(d1).addClass("body-right").html(result["listWordCategory"][j].contentWord).appendTo($("#body-content"))
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert("Occur errors");
				}
			});
		});
		
		$('#selectedCategory').click(function() {	
			var selectedCategory = $("#selectedCategory").val();
			var learnedStatus = $("input[name='learnedStatus']:checked").val();
			$.ajax({
				url : 'filterAction.action',
				type : 'post',
				data : {'selectedCategory':selectedCategory,'learnedStatus':learnedStatus},
				dataType : 'json',
				success : function(result) {
					$("#body-content").empty();
					for( j = 0; j < result["listWordCategory"].length; j++ ){					
						d = document.createElement('div');
						$(d).addClass("body-left").html(result["listWordCategory"][j].contentResult).appendTo($("#body-content")) 
						d1 = document.createElement('div');
						$(d1).addClass("body-right").html(result["listWordCategory"][j].contentWord).appendTo($("#body-content"))
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert("Occur errors");
				}
			});
		});				
	});