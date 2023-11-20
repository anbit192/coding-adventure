import React from "react";
import ChildComponent from "./ChildComponent";
class TestComponent extends React.Component {

    state = {
        fname: "",
        lname: ""
    }

    handleChangeFirstName = (event) => {
        this.setState({
            fname: event.target.value
        })
    }

    handleChangeLastName = (event) => {
        this.setState({
            lname: event.target.value
        })
    }

    handleSubmit = (event) => {
        event.preventDefault()
        alert("Clicked!")
        console.log(this.state)
    }

    render() {

        console.log(">> render: ", this.state)

        return (
            <>
                <div>
                    <form>
                        <label for="fname">First name: </label>
                        <input type="text" value={this.state.fname}
                            onChange={(event) => { this.handleChangeFirstName(event) }} />
                        <br />
                        <label for="lname">Last name: </label>
                        <input type="text" value={this.state.lname}
                            onChange={(event) => { this.handleChangeLastName(event) }} />
                        <br />
                        <input type="submit" value="SUBMIT"
                            onClick={(event) => { this.handleSubmit(event) }} />
                    </form>

                </div>

                <ChildComponent name={"Nguyen Minh An"} age={20} />

            </>

        );
    }
}

export default TestComponent;