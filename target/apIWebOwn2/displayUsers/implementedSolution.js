import Person from "./implementedEntities/Person.js";
import House from "./implementedEntities/House.js";

import {generateView} from "./genericSolutions/tableGenerator.js";
import {generateForm} from "./genericSolutions/formGenerator.js";

const person = new Person("http://localhost:8081/api/user");
const house = new House("http://localhost:8081/api/house");

generateView(house.displayURI);
generateForm(house, "POST");
generateForm(house, "GET");
generateForm(house, "DELETE");
//generateForm(house, "PUT"); //put and POST cannot be on the same page <-- also that would be super wierd


//call table generator here
//call data generator here / inside data generator
