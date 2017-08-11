$(document).ready(
		function() {
			$('#mainForm').validate(
					{
						rules : {
							'password' : {
								required : true
							},
							'repassword' : {
								required : true,
								equalTo : 'input[name="repassword"]'
							}
						}
					});

			$('#mainForm').ajaxForm(
					{
						'dataType' : 'json',
						'clearForm' : true,
						'url':ROOF.Utils.projectName()+"/userAction/update_pwd.json",
						'success' : function(d) {
							ROOF.Utils.hideBlock();
							ROOF.Utils.alert(d.message, function() {
								if ($('#backBtn').attr('href')) {
									window.location.href = $('#backBtn').attr(
											'href');
								}
							});
						},
						'beforeSerialize' : function() {
							var password = $('input[name="password"]');
							var repassword = $('input[name="repassword"]');
							if (!hex_md5_tip(password.val()).toUpperCase()) {
								password.focus();
								return false;
							} else if (!hex_md5_tip(repassword.val())
									.toUpperCase()) {
								repassword.focus();
								return false;
							} else if (password.val() != repassword.val()) {
								alert("密码和重复密码不一致");
								repassword.select();
								return false;
							}
							password.val(hex_md5_tip(password.val())
									.toUpperCase());
							repassword.val(hex_md5_tip(repassword.val())
									.toUpperCase());
						}
					});

			$('#saveBtn1').click(function() {
				$('#mainForm').submit();
				return false;
			});


		});
