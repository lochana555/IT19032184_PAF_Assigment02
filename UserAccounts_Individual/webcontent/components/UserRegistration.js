 $(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
{
$("#alertSuccess").hide();
}
$("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
$("#alertSuccess").text("");
$("#alertSuccess").hide();
$("#alertError").text("");
$("#alertError").hide();

// Form validation-------------------
var status = validateUserForm();

// If not valid-------------------
if (status != true)
{
$("#alertError").text(status);
$("#alertError").show();
return;
}

// If valid------------------------
var type = ($("#hidUIDSave").val() == "") ? "POST" : "PUT";
$.ajax(
{
url : "UserAPI",
type : type,
data : $("#formUserRegistration").serialize(),
dataType : "text",
complete : function(response, status)
{
onUserSaveComplete(response.responseText, status);
}
});
});


function onUserSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divUserGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} 
	else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidUIDSave").val("");
	$("#formUserRegistration")[0].reset();
	}
	
	//form fill  ============================================

$(document).on("click", ".btnUpdate", function(event)
{
$("#hidUIDSave").val($(this).closest("tr").find('#hidUIDUpdate').val());
$("#uname").val($(this).closest("tr").find('td:eq(0)').text());
$("#password").val($(this).closest("tr").find('td:eq(1)').text());
$("#email").val($(this).closest("tr").find('td:eq(2)').text());
$("#age").val($(this).closest("tr").find('td:eq(3)').text());
$("#address").val($(this).closest("tr").find('td:eq(4)').text());
$("#type").val($(this).closest("tr").find('td:eq(5)').text());
});

//CLIENT-MODEL  ============================================

function validateUserForm()
{
	
	// Name
	if ($("#uname").val().trim() == "")
	{
		return "Insert User Name.";
	}
	
	
	// Password
	if ($("#password").val().trim() == "")
	{
		return "Insert Password.";
	}
	
	// Email
	if ($("#email").val().trim() == "")
	{
		return "Insert Email Address.";
	}
	
	// Age
	if ($("#age").val().trim() == "")
	{
		return "Insert Age.";
	}
	
	// Address
	if ($("#address").val().trim() == "")
	{
		return "Insert Address.";
	}
	
	// Type
	if ($("#type").val().trim() == "")
	{
		return "Insert User Type.";
	}
	
return true;
}

//DELETE
$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
	{
		url : "UserAPI",
		type : "DELETE",
		data : "uid=" + $(this).data("uid"),
		dataType : "text",
		complete : function(response, status)
		{
			onUserDeleteComplete(response.responseText, status);
		}
	});
});


function onUserDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
			if (resultSet.status.trim() == "success")
			{
				$("#alertSuccess").text("Successfully deleted.");
				$("#alertSuccess").show();
				$("#divUserGrid").html(resultSet.data);
			} else if (resultSet.status.trim() == "error")
				
			{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
			}
	
	} else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}