import './App.css';


function App() {
  return (
    <div className="App">
      <User name = "anbish" dob = "19/02/2003" handsome = "Yes" />
    </div>
  );
}



function User(props) {
  return (
    <div>
      <h1>
        Name: {props.name} <br/>
        DOB: {props.dob} <br />
        handsome: {props.handsome} <br/>
      </h1>
    </div>
  );
}

export default App;
