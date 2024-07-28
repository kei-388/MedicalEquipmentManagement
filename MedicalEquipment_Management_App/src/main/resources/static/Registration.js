document.addEventListener("DOMContentLoaded", function() {
	const form = document.querySelector(".form");
	const managementNumber = document.getElementById("management-number");
	const deviceName = document.getElementById("device-name");
	const category = document.getElementById("category");
	const remarks = document.getElementById("remarks");
	const managementDepartment = document.getElementById("management-department");
	const purchaser = document.getElementById("purchaser");
	const yearsOfUse = document.getElementById("years-of-use");
	const startDate = document.getElementById("start-date");

	form.addEventListener("submit", function(event) {
		let valid = true;

		if (managementNumber.value.trim() === "") {
			showError(managementNumber, "管理番号を入力してください");
			valid = false;
		} else {
			clearError(managementNumber);
		}

		if (deviceName.value.trim() === "") {
			showError(deviceName, "機器名を入力してください");
			valid = false;
		} else {
			clearError(deviceName);
		}

		if (category.value.trim() === "") {
			showError(category, "種別を入力してください");
			valid = false;
		} else {
			clearError(category);
		}

		if (managementDepartment.value.trim() === "") {
			showError(managementDepartment, "管理部署を入力してください");
			valid = false;
		} else {
			clearError(managementDepartment);
		}

		if (purchaser.value.trim() === "") {
			showError(purchaser, "調達先を入力してください");
			valid = false;
		} else {
			clearError(purchaser);
		}

		if (yearsOfUse.value.trim() === "" || isNaN(yearsOfUse.value) || parseInt(yearsOfUse.value) < 0 || parseInt(yearsOfUse.value) > 100) {
			showError(yearsOfUse, "耐用年数は0から100の間で入力してください");
			valid = false;
		} else {
			clearError(yearsOfUse);
		}

		if (startDate.value.trim() === "") {
			showError(startDate, "使用開始日を入力してください");
			valid = false;
		} else {
			clearError(startDate);
		}

		if (!valid) {
			event.preventDefault();
		}
	});

	function showError(input, message) {
		const error = document.createElement("div");
		error.className = "error-message";
		error.innerText = message;
		if (input.nextSibling && input.nextSibling.className === "error-message") {
			input.parentNode.removeChild(input.nextSibling);
		}
		input.parentNode.insertBefore(error, input.nextSibling);
	}

	function clearError(input) {
		if (input.nextSibling && input.nextSibling.className === "error-message") {
			input.parentNode.removeChild(input.nextSibling);
		}
	}
});
