/**
 * 
 */
$(document).ready(
		function() {
			$('#radioBtnForm input').on(
					'change',
					function() {
						answer = $('input[name=answerContent]:checked',
								'#radioBtnForm').next().text();
						$("#answerId").text(answer);
						window.location = "solveProblem?userAnswerContent="
								+ $("#answerId").text();
					});
		});