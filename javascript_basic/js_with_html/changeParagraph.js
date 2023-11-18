
function changeParagraph() {
    document.getElementById("demo").innerHTML = "Surprise MTFK";   
}

const hoverIn = () => {
    const htmlCollection = document.getElementsByClassName("test-js");
    for (let i = 0; i < htmlCollection.length; i++) {
        htmlCollection[i].innerHTML = "Gotcha!"
    }
};

const hoverOut = () => {
    const htmlCollection = document.getElementsByClassName("test-js");
    for (let i = 0; i < htmlCollection.length; i++) {
        htmlCollection[i].innerHTML = "What's wrong?"
    }
}