import React from "react";
import ChildComponent from "./ChildComponent";
class TestComponent extends React.Component {

    state = {
        fname: "",
        lname: "",
        arrayJobs: [
            {
                id: "job1",
                title: "dev",
                salary: "9999$"
            },
            {
                id: "job2",
                title: "tester",
                salary: "6969$"
            },
            {
                id: "job3",
                title: "manager",
                salary: "99999$"
            }
        ]
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

    handleChangeAge = (event) => {
        this.setState({
            age: event.target.value
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
                        <label for="lname">Age: </label>
                        <input type="text" value={this.state.age}
                            onChange={(event) => { this.handleChangeAge(event) }} />
                        <br />
                        <input type="submit" value="SUBMIT"
                            onClick={(event) => { this.handleSubmit(event) }} />
                    </form>

                </div>

                <ChildComponent name={this.state.fname} age={this.state.age}
                    address={"Ha Noi"} jobs={this.state.arrayJobs} />

            </>

        );
    }
}

export default TestComponent;