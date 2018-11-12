class House {
    constructor(defaultURI) {
        this.defaultURI = defaultURI;
    }

    get displayURI() {
        return this.defaultURI;
    }

    objectList() {
        let entityAttributes = [
            {"id" : "number" },
            {"size" : "number"},
            {"zipcode" : "number"},
            {"address" : "text"},
            {"profilePicture" : "text"}
         ]
        return entityAttributes;
    }
}

export default House;