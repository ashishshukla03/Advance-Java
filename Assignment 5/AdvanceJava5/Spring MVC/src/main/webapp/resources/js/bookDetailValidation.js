const isCodeValid = () => {
	let code = document.getElementById("code");
	const cdErrDiv = document.getElementById("code-err");
	if (code.value == "") {
		cdErrDiv.classList.remove("no-error");
		cdErrDiv.classList.add("error-msg");
		return false;
	} else {
		cdErrDiv.classList.remove("error-msg");
		cdErrDiv.classList.add("no-error");
		return true;
	}
}

const isTitleValid = () => {
	const name = document.getElementById("name");
	const nmErrDiv = document.getElementById("name-err");
	if (name.value == "") {
		nmErrDiv.classList.remove("no-error");
		nmErrDiv.classList.add("error-msg");
		return false;
	} else {
		nmErrDiv.classList.remove("error-msg");
		nmErrDiv.classList.add("no-error");
		return true;
	}

}

function validateAddBookDetail() {
	const code = isCodeValid();
	const title = isTitleValid();
	return code && title;
}

