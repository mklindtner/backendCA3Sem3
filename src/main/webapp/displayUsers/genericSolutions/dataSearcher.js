function searchAPI(url, callback) {
    return fetch(url, callback);
}

//remember id
export function fetchGetOrDelete(typeOfForm, path, callback) {
    searchAPI(path, {
        method: typeOfForm,
    })
        .then(response => {
            console.log("path: " + path)
            console.log("typeofForm: " + typeOfForm)
            return response.json();
        })
        .then(body => {
                console.log(body);
                //callback(body); use this if you want to do something with the body on afunction
            }
        );
}


export function fetchCreateAndUpdate(typeOfForm, path, resultObject) {
    searchAPI(path, {
        method: typeOfForm,
        headers: {
            "Content-type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify(resultObject)
    })
}



