/*Inserting main variables*/

let adventureHolidays = document.getElementById("adventureHolidays");
let backpacking = document.getElementById("backpacking");
let cruiseHolidays = document.getElementById("cruiseHolidays");
let eventTravel = document.getElementById("eventTravel");
let packageHoliday = document.getElementById("packageHoliday");
let safari = document.getElementById("safari");
let skiingAndSnowboarding = document.getElementById("skiingAndSnowboarding");
let volunteering = document.getElementById("volunteering");
/*End of inserting main variables*/

/*sub variables*/

let ahSummerCamps = document.getElementById("aH-summerCamps");
let ahTrekking = document.getElementById("aH-trekking");
let bPLongDistanceHiking = document.getElementById("bP-longDistanceHiking");
let bPThruHiking = document.getElementById("bP-thruHiking");
let cOceanCruising = document.getElementById("c-oceanCruising");
let cRiverCruising = document.getElementById("c-riverCruising");
let eRecreationsEvent = document.getElementById("e-recreationsEvent");
let eSportsEvent = document.getElementById("e-sportsEvents");
let phEscortedTours = document.getElementById("pH-escortedTours");
let phIndependentTours = document.getElementById("pH-independentTours");
let sPhotographicSafari = document.getElementById("s-photographicSafari");
let sCyclingSafari = document.getElementById("s-cyclingSafari");
let sAsBackcountrySkiing = document.getElementById("sAs-backcountrySkiing");
let sAsDownhillSkiing = document.getElementById("sAs-downhillSkiing");
let vChildcare = document.getElementById("v-childcare");
let vConservationAndEnvironment = document.getElementById("v-conservationAndEnvironment");

/*end of subs variables*/

window.onload = function () {
    hideAllSubDivs(subDivs);
    choice();
};

const allDivs = ["adventureHolidays", "backpacking", "cruiseHolidays", "eventTravel", "packageHoliday", "safari", "skiingAndSnowboarding", "volunteering", "aH-summerCamps", "aH-trekking", "bP-longDistanceHiking", "bP-thruHiking", "c-oceanCruising", "c-riverCruising", "e-recreationsEvent", "e-sportsEvents", "pH-escortedTours", "pH-independentTours", "s-photographicSafari", "s-cyclingSafari", "sAs-backcountrySkiing", "v-conservationAndEnvironment", "sAs-downhillSkiing", "v-childcare"]
    .map(id => document.getElementById(id)); // gives you an array of those elements

const subDivs = ["aH-summerCamps", "aH-trekking", "bP-longDistanceHiking", "bP-thruHiking", "c-oceanCruising", "c-riverCruising", "e-recreationsEvent", "e-sportsEvents", "pH-escortedTours", "pH-independentTours", "s-photographicSafari", "s-cyclingSafari", "sAs-backcountrySkiing", "v-conservationAndEnvironment", "sAs-downhillSkiing", "v-childcare"]
    .map(id => document.getElementById(id)); // gives you an array of those elements

function hideAllSubDivs(id) {
    for (const div of subDivs) div.hidden = !(div.id === id);
}

function hideAllDivsExcept(id, ids) {
    for (const div of allDivs) div.hidden = !(div.id === id) && !(div.id === ids);
}

function choice() {
    adventureHolidays.addEventListener("click", () => {
        hideAllDivsExcept('aH-summerCamps', 'aH-trekking');
        console.log("adventure holidays");
    })
    backpacking.addEventListener("click", () => {
        hideAllDivsExcept('bP-longDistanceHiking', 'bP-thruHiking');
        console.log("backpacking");
    })
    cruiseHolidays.addEventListener("click", () => {
        hideAllDivsExcept('c-oceanCruising', 'c-riverCruising');
        console.log("cruise");
    })
    eventTravel.addEventListener("click", () => {
        hideAllDivsExcept('e-recreationsEvent', 'e-sportsEvents');
        console.log("event");
    })
    packageHoliday.addEventListener("click", () => {
        hideAllDivsExcept('pH-escortedTours', 'pH-independentTours');
        console.log("package holiday");
    })
    safari.addEventListener("click", () => {
        hideAllDivsExcept('s-photographicSafari', 's-cyclingSafari');
        console.log("safari");
    })
    skiingAndSnowboarding.addEventListener("click", () => {
        hideAllDivsExcept('sAs-downhillSkiing', 'sAs-backcountrySkiing');
        console.log("skiing and snowboarding");
    })
    volunteering.addEventListener("click", () => {
        hideAllDivsExcept('v-childcare', 'v-conservationAndEnvironment');
        console.log("volunteering");
    })
}


/* start of function choice for user clicks*/



