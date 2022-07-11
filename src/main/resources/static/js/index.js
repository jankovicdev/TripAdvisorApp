/*Inserting main variables*/

const adventureHolidays = document.getElementById("adventureHolidays");
const backpacking = document.getElementById("backpacking");
const cruiseHolidays = document.getElementById("cruiseHolidays");
const eventTravel = document.getElementById("eventTravel");
const packageHoliday = document.getElementById("packageHoliday");
const safari = document.getElementById("safari");
const skiingAndSnowboarding = document.getElementById("skiingAndSnowboarding");
const volunteering = document.getElementById("volunteering");
/*End of inserting main variables*/

/*sub variables*/

const ahSummerCamps = document.getElementById("aH-summerCamps");
const ahTrekking = document.getElementById("aH-trekking");
const bPLongDistanceHiking = document.getElementById("bP-longDistanceHiking");
const bPThruHiking = document.getElementById("bP-thruHiking");
const cOceanCruising = document.getElementById("c-oceanCruising");
const cRiverCruising = document.getElementById("c-riverCruising");
const eRecreationsEvent = document.getElementById("e-recreationsEvent");
const eSportsEvent = document.getElementById("e-sportsEvents");
const phEscortedTours = document.getElementById("pH-escortedTours");
const phIndependentTours = document.getElementById("pH-independentTours");
const sPhotographicSafari = document.getElementById("s-photographicSafari");
const sCyclingSafari = document.getElementById("s-cyclingSafari");
const sAsBackcountrySkiing = document.getElementById("sAs-backcountrySkiing");
const sAsDownhillSkiing = document.getElementById("sAs-downhillSkiing");
const vChildcare = document.getElementById("v-childcare");
const vConservationAndEnvironment = document.getElementById("v-conservationAndEnvironment");

/*end of subs variables*/

window.onload = function () {
    hideAllSubDivs(subDivs);
    choice();
};

const allDivs = ["adventureHolidays", "backpacking", "cruiseHolidays", "eventTravel", "packageHoliday", "safari", "skiingAndSnowboarding", "volunteering", "aH-summerCamps", "aH-trekking", "bP-longDistanceHiking", "bP-thruHiking", "c-oceanCruising", "c-riverCruising", "e-recreationsEvent", "e-sportsEvents", "pH-escortedTours", "pH-independentTours", "s-photographicSafari", "s-cyclingSafari", "sAs-backcountrySkiing", "v-conservationAndEnvironment", "sAs-downhillSkiing", "v-childcare"]
    .map(id => document.getElementById(id));
const subDivs = ["aH-summerCamps", "aH-trekking", "bP-longDistanceHiking", "bP-thruHiking", "c-oceanCruising", "c-riverCruising", "e-recreationsEvent", "e-sportsEvents", "pH-escortedTours", "pH-independentTours", "s-photographicSafari", "s-cyclingSafari", "sAs-backcountrySkiing", "v-conservationAndEnvironment", "sAs-downhillSkiing", "v-childcare"]
    .map(id => document.getElementById(id));

function hideAllSubDivs(id) {
    for (const div of subDivs) div.hidden = !(div.id === id);
}

function hideAllDivsExcept(id, ids) {
    for (const div of allDivs) div.hidden = !(div.id === id) && !(div.id === ids);
}

function choice() {
    adventureHolidays.addEventListener("click", () => {
        hideAllDivsExcept('aH-summerCamps', 'aH-trekking');
    })
    backpacking.addEventListener("click", () => {
        hideAllDivsExcept('bP-longDistanceHiking', 'bP-thruHiking');
    })
    cruiseHolidays.addEventListener("click", () => {
        hideAllDivsExcept('c-oceanCruising', 'c-riverCruising');
    })
    eventTravel.addEventListener("click", () => {
        hideAllDivsExcept('e-recreationsEvent', 'e-sportsEvents');
    })
    packageHoliday.addEventListener("click", () => {
        hideAllDivsExcept('pH-escortedTours', 'pH-independentTours');
    })
    safari.addEventListener("click", () => {
        hideAllDivsExcept('s-photographicSafari', 's-cyclingSafari');
    })
    skiingAndSnowboarding.addEventListener("click", () => {
        hideAllDivsExcept('sAs-downhillSkiing', 'sAs-backcountrySkiing');
    })
    volunteering.addEventListener("click", () => {
        hideAllDivsExcept('v-childcare', 'v-conservationAndEnvironment');
    })
    ahSummerCamps.addEventListener("click", () => {
        location.href = "/adventureHolidays/getRandomSummerCamps";
    })
    ahTrekking.addEventListener("click", () => {
        location.href = "/adventureHolidays/getRandomTrekking";
    })
    bPLongDistanceHiking.addEventListener("click", () => {
        location.href = "/backpacking/getRandomLongDistanceHiking";
    })
    bPThruHiking.addEventListener("click", () => {
        location.href = "/backpacking/getRandomThruHiking";
    })
    cOceanCruising.addEventListener("click", () => {
        location.href = "/cruiseHolidays/getRandomOceanCruising";
    })
    cRiverCruising.addEventListener("click", () => {
        location.href = "/cruiseHolidays/getRandomRiverCruising";
    })
    eRecreationsEvent.addEventListener("click", () => {
        location.href = "/eventTravel/getRandomRecreationsEvents";
    })
    eSportsEvent.addEventListener("click", () => {
        location.href = "/eventTravel/getRandomSportsEvents";
    })
    phIndependentTours.addEventListener("click", () => {
        location.href = "/packageHoliday/getRandomIndependentTours";
    })
    phEscortedTours.addEventListener("click", () => {
        location.href = "/packageHoliday/getRandomEscortedTours";
    })
    sPhotographicSafari.addEventListener("click", () => {
        location.href = "/safari/getRandomPhotographicSafari";
    })
    sCyclingSafari.addEventListener("click", () => {
        location.href = "/safari/getRandomCyclingSafari";
    })
    sAsBackcountrySkiing.addEventListener("click", () => {
        location.href = "/skiingAndSnowboarding/getRandomBackcountrySkiing";
    })
    sAsDownhillSkiing.addEventListener("click", () => {
        location.href = "/skiingAndSnowboarding/getRandomDownhillSkiing";
    })
    vChildcare.addEventListener("click", () => {
        location.href = "/volunteering/getRandomChildcare";
    })
    vConservationAndEnvironment.addEventListener("click", () => {
        location.href = "/volunteering/getRandomConservationAndEnvironment";
    })
}


/* start of function choice for user clicks*/



