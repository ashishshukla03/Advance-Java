const isEmailValid = () => {
	let email = document.getElementById("email");
	let emailRegex = /^([a-zA-Z0-9._-]+)@([a-zA-Z0-9]+\.)+[a-zA-Z]{2,4}$/i;
	const userErrDiv = document.getElementById("usr-err");
	if (!emailRegex.test(email.value)) {
		userErrDiv.classList.remove("no-error");
		userErrDiv.classList.add("error-msg");
		return false;
	} else {
		userErrDiv.classList.remove("error-msg");
		userErrDiv.classList.add("no-error");
		return true;
	}
}

const isPasswordValid = () => {
	const password = document.getElementById("password");
	const pwdErrDiv = document.getElementById("pwd-err");
	const passErrDiv = document.getElementById("color-err");
	if (password.length<5) {
		pwdErrDiv.classList.remove("no-error");
		pwdErrDiv.classList.add("error-msg");
		return false;
	} else {
		pwdErrDiv.classList.remove("error-msg");
		pwdErrDiv.classList.add("no-error");
		return true;
	}

}

function validateUser() {
	const username = isEmailValid();
	const password = isPasswordValid();
	return username && password;
}
