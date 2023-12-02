import React from "react";

class AddComponent extends React.Component {

    state = {
        title: "",
        salary: "",
    }

    handleChangetitle = (event) => {
        this.setState({
            title: event.target.value
        })
    }

    handleChangeSalary = (event) => {
        this.setState({
            salary: event.target.value
        })
    }

    handleSubmit = (event) => {
        event.preventDefault();
        // alert("Clicked!");
        if (!this.state.title || !this.state.salary) {
            alert("Missing!")
            return;
        }
        console.log(this.state);
        let jobID = "job" + (this.props.length + 1);
        // console.log(jobID)
        this.props.addNewJob({
            id: jobID,
            title: this.state.title,
            salary: this.state.salary
        })

        this.setState({
            title: "",
            salary: ""
        })
    }

    render() {
        return (
            <>
                <form>
                    <label htmlFor="fname">Job name: </label> <br />
                    <input type="text" value={this.state.fname}
                        onChange={(event) => { this.handleChangetitle(event) }} />
                    <br />
                    <label htmlFor="lname">Salary: </label> <br />
                    <input type="text" value={this.state.lname}
                        onChange={(event) => { this.handleChangeSalary(event) }} />
                    <br />
                    <input type="submit" value="SUBMIT"
                        onClick={(event) => { this.handleSubmit(event) }} />
                </form>
            </>
        )
    }
}

export default AddComponent;