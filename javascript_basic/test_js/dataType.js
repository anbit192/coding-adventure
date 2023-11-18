// number
let intNumber = 19;
let floatNumber = 1.92;

//string
let myString = "anbish";
let anotherString = "192";

// bool
let myBoolean = true;

//object
const personA = {
    name : "anbish",
    age : 20
};

const personB = {
    name : "anbit",
    age : 21,
    playGame : function(game) {
        return this.name + " is playing " + game;
    }
};

console.log("personA's name: " + personA.name);
console.log("personB's name: " + personB.name);
console.log(personB.playGame("Doto"));



// array
const persons = [personA, personB];
console.log(persons);

// date
const date = new Date("2023-02-19");
console.log(date);


// function 
function funcA() {
    console.log("do A");
};

funcA();


const funcB = (a=1, b=2) => {
    console.log(a + b);
}
funcB();



