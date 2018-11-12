class Person {
    
    constructor(defaultURI) {
        this.defaultURI = defaultURI;
    }

    //make getter for defaultURI
    get displayURI() {
        return this.defaultURI;
    }


    objectList() {
        let entityAttributes = [
            { "id" : "number"}, //first item must be PK for PUT or GET {id}
            { "name": "text" },
            { "email": "email" },
            { "hashPassword": "text" }
        ];
        return entityAttributes;
    }
}

export default Person;

//uhh pasword is insecure q.q