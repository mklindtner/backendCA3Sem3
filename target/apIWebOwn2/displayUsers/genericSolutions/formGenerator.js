//import Person from "../implementedEntities/Person.js";
//import House from "../implementedEntities/House.js";
import {fetchCreateAndUpdate, fetchGetOrDelete} from "../genericSolutions/dataSearcher.js";


const divCRUD = document.getElementById("dataCRUDResource");

export function generateForm(entityInJS, optionalMethod) {
    console.log("entity: " + entityInJS);
    let objectList = entityInJS.objectList;
    const form = document.createElement("FORM");
    const typeOfForm = formMethod(optionalMethod);
    const URI = formAction(entityInJS, typeOfForm);

    form.appendChild( headerName(typeOfForm) );
    form.id = "gForm";

    appendProperForms(form, entityInJS.objectList(), typeOfForm);

    form.appendChild(generateSubmitButton(objectList(), typeOfForm, URI));
    divCRUD.appendChild(form);
    return form;
}

function headerName( typeOfForm ) {
    const h3 = document.createElement("h3");
    h3.innerText = typeOfForm + " Form";
    return h3;
}

function appendProperForms(form, objectList, typeOfForm) {
    for (let i in objectList) {
        if (useField(i, typeOfForm)) {
            form.appendChild(generateInputFields(objectList[i]));
            form.appendChild(generateLabelFields(objectList[i]));
        }
    }
}

function useField(i, typeOfForm) {
    if (i === "0" && typeOfForm === "POST")//do not add PK to POST
        return false;
    if(i !== "0" && (typeOfForm === "GET" || typeOfForm === "DELETE") )
        return false;
    return true;
}

function formMethod(optionalMethod) {
    return optionalMethod != null ? optionalMethod : "POST"; //default
}

function formAction(entityJS) {
    //change to URI in param
    return entityJS.displayURI != null ? entityJS.displayURI : "";
}


function generateInputFields(singleObject) {
    const userInput = document.createElement("INPUT");
    userInput.name = Object.keys(singleObject);
    userInput.id = Object.keys(singleObject);
    return userInput;
}

//use document.createTextNode instead for easier maintence
function generateLabelFields(singleObject) {
    const label = document.createElement("LABEL");
    label.innerHTML = Object.keys(singleObject);

    const br = document.createElement("br");
    label.appendChild(br);
    return label;
}

function generateSubmitButton(objectList, typeOfForm, path) {
    const button = document.createElement("button");
    button.id = "gFormbutton" + typeOfForm;
    button.innerText = "submit";
    button.addEventListener('click', (e) => {
        e.preventDefault();
        let finalPath = changePath(path, objectList, typeOfForm);
        CRUD(objectList, typeOfForm, finalPath);
    });
    return button;
}

function changePath(path, objectList, typeOfForm) {
    let finalPath = path;
    if (typeOfForm === "PUT" || typeOfForm === "GET"  || typeOfForm === "DELETE") //GET untested for now
        return finalPath += "/" + document.getElementById(Object.keys(objectList[0])).value;
    return finalPath;
}

function CRUD(objectList, typeOfForm, path) {
    let resultObject = generateResultList(objectList, typeOfForm);
    console.log(JSON.stringify(resultObject)); //works
    if(typeOfForm === "POST" || typeOfForm === "PUT") {
        fetchCreateAndUpdate(typeOfForm, path, resultObject);
    }
    if(typeOfForm === "DELETE" || typeOfForm === "GET") {
        fetchGetOrDelete(typeOfForm, path);
    }

}

function generateResultList(objectList, typeOfForm) {
    let resultObject = {};
    for (let i in objectList) {
        let currKey = Object.keys(objectList[i]);
        if (useField(i, typeOfForm)) {
            const currFieldValue = document.getElementById(Object.keys(objectList[i])).value //get value from fields
            resultObject[currKey] = currFieldValue;
        }
    }
    return resultObject;
}

//exampleDTO
//const person = new Person("http://localhost:8081/api/user");
//when POST & PUT is called after each other it doesn't work on 2nd one, why ?
//generateForm(person, "GET");
//generateForm(person, "POST");
//generateForm(person, "DELETE");


//const house = new House("http://localhost:8081/api/house");
//generateForm(house, "POST");

