
doRequest("/cuisines", readCuisinesList);

var input = document.getElementById("nOfSeats");

// Execute a function when the user releases a key on the keyboard
input.addEventListener("keyup", function(event) {
  // Cancel the default action, if needed
  event.preventDefault();
  // Number 13 is the "Enter" key on the keyboard
  if (event.keyCode === 13) {
    // Trigger the button element with a click
    document.getElementById("searchButton").click();
  }
});

var cuisineList;
function processFormData(){

        var cuisineName = document.getElementById("cuisine");
        var searchedCuisine = cuisineName.value;

        var numberOfSeats = document.getElementById("nOfSeats");
        var neededSeats = numberOfSeats.value;

        var restaurantTableTo;

        function readTableList(){
            restaurantTableTo = JSON.parse(this.responseText);
            console.log(restaurantTableTo.length);

                go(restaurantTableTo);

            }
       // function createRestaurantRow(restaurant)

        function createRow(restaurantObject){

                var template = document.querySelector("#restaurantGridTemplate");
                var clone = document.importNode(template.content, true);

                var restaurant = restaurantObject.restaurant;
                var tables = restaurantObject.tables;

                clone.querySelector(".logo").src = restaurant.photoPath;
                clone.querySelector(".restaurant-name").textContent = restaurant.restaurantName;


                clone.querySelector(".restaurant-address").innerHTML = "<p>" + restaurant.address +", " + restaurant.city + "</p>" +
                                                                       "<p>" + "tel: +49" + restaurant.phoneNumber + "</p>" +
                                                                       "<p><b>" + restaurant.cuisine + "</b><p>";




                var tableBoxTemplate = document.querySelector("#tableTemplate");

                for( var i = 0; i < tables.length; i++){
                     var amountOfSeats = tables[i].amountOfSeats;
                     var tableBox = document.importNode(tableBoxTemplate.content, true);
                     var seatElement = document.createElement("b");
                     seatElement.textContent = amountOfSeats;
                     tableBox.querySelector(".table-line").appendChild(seatElement);
                     clone.querySelector(".tables-list").appendChild(tableBox);

                    }

                    return clone;
                    }

        function insertRow(restaurantObject){
            var insertRow = createRow(restaurantObject);
            document.querySelector("#resultsField").appendChild(insertRow);
}


        function go(list){
            document.querySelector("#resultsField").innerHTML="";
            for (var i = 0; i < list.length; i++){
                var restaurant =list[i];
                insertRow(restaurant);
             }
        }

            doRequest2("/tables", readTableList, neededSeats, searchedCuisine);


        }


 function doRequest(url, functionName, parameter)  {
        var oReq = new XMLHttpRequest();
        oReq.onload = functionName;
        if (parameter) {
            url = url + "?numberOfSeats=" + parameter;
        }
        oReq.open("get", url, false);
        oReq.send();
    }

 function doRequest2(url, functionName, parameter1, parameter2)  {
        var oReq = new XMLHttpRequest();
        oReq.onload = functionName;
        url = url + "?numberOfSeats=" + parameter1 + "&cuisine=" + parameter2;
        oReq.open("get", url, false);
        oReq.send();
    }





    function readCuisinesList(){
       cuisineList = JSON.parse(this.responseText);

        var selectCuisineList = document.getElementById("cuisine");
        for ( var i = 0; i < cuisineList.length; i++){
            var option = document.createElement("option");
            option.value = cuisineList[i];
            option.text =  cuisineList[i];
            selectCuisineList.appendChild(option);
        }


    }
