let resource = [];
const divTable = document.getElementById("tableResource1");

export function generateView(path) {
    fetch(path)
        .then(response => {
            return response.json()
        })
        .then(responseAsJson => {
            tableGenerator( resourceToArray(responseAsJson) )
        })
}

function resourceToArray(json) {
    json.map(r => resource.push(r) );
    return resource;
}

function tableGenerator(resourceList) {
    let headerResource = [];
    const table = document.createElement("table");

    Object.keys(resourceList[0]).map( (v) => {
            headerResource.push(v)
    });

    table.appendChild( tableHeader(headerResource) );
    table.appendChild( tableData(resource) );


    divTable.appendChild(table);
    return table;
}

function tableHeader(resourceHeaders) {
    const tableHeader = document.createElement("thead");
    const tableRow = document.createElement("tr");
    resourceHeaders.map(resource => {
        const th = document.createElement("th");
        th.innerText = resource;
        tableRow.appendChild(th);
    });

    tableHeader.appendChild(tableRow);
    return tableHeader;
}

function tableData(resourceData) {
    const tableBody = document.createElement("tbody");
    resourceData.map(resource => {
        let resourceValues = Object.values(resource);
        tableBody.appendChild(dataRowEntry(resourceValues));
    });
    return tableBody;
}

function dataRowEntry(resourceValues) {
    const tableRow = document.createElement("tr"); //one tr for all td's
    resourceValues.map(singleResourceValue => {
            const tableData = document.createElement("td");
            tableData.innerText = singleResourceValue;
            tableRow.appendChild(tableData);
        }
    );
    return tableRow;
}

//exampleDTO
//generateView("http://localhost:8081/api/user");
//generateView("http://localhost:8081/api/house");
