import React from "react";
import ChildComponent from "./ChildComponent";
import AddComponent from "./AddComponent";
class TestComponent extends React.Component {

    state = {
        arrayJobs: [
            {
                id: "job1",
                title: "dev",
                salary: 9999
            },
            {
                id: "job2",
                title: "tester",
                salary: 6969
            },
            {
                id: "job3",
                title: "manager",
                salary: 99999
            }
        ]
    }


    addNewJob = (job) => {
        // let currentJobs = this.state.arrayJobs
        this.setState({
            arrayJobs: [...this.state.arrayJobs, job]
        })
    }

    deleteJob = (job) => {

        let currentJobs = this.state.arrayJobs;
        currentJobs = currentJobs.filter(item => item.id !== job.id);
        this.setState({
            arrayJobs: currentJobs
        })
    }

    render() {

        console.log(">> render: ", this.state)

        return (
            <>
                <div>
                    <AddComponent addNewJob={this.addNewJob} length={this.state.arrayJobs.length}/>
                </div>

                <ChildComponent jobs={this.state.arrayJobs} deleteJob={this.deleteJob}/>

            </>

        );
    }
}

export default TestComponent;