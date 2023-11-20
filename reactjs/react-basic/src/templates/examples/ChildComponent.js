import React from "react";
class ChildComponent extends React.Component {

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

        console.log(">> check props: ", this.props)
        let name = this.props.name
        let age = this.props.age

        return (
            <>
                <div>
                    name: {name} <br />
                    age: {age}
                </div>
            </>

        );
    }
}

export default ChildComponent;