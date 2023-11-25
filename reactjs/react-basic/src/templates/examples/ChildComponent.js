import React from "react";
class ChildComponent extends React.Component {

    state = {
        showJobs: false
    }

    showJobsHandler = () => {
        this.setState({
            showJobs: !this.state.showJobs
        })
    }

    render() {
        let { name, age, address, jobs } = this.props;
        let showJobs = this.state.showJobs;
        return (
            <div>
                {
                    // if (showJobs == False) => (render show) else (render hide)
                    (showJobs === false) ?
                        <>
                            <button onClick={() => { this.showJobsHandler() }}>SHOW</button>
                        </>
                        :
                        <>
                            <div>
                                {
                                    jobs.map((job, index) => {
                                        return (
                                            <>
                                                <div key={job.id}>
                                                    {job.title} - {job.salary}
                                                </div>
                                            </>
                                        )
                                    })
                                }

                            </div>
                            <button onClick={() => { this.showJobsHandler() }}>HIDE</button>
                        </>

                }

            </div>
        )
    }
}


// function component

// const ChildComponent = (props) => {
//     console.log("Check child props: ", props)

//     let { name, age, address, jobs } = props;
//     return (
//         <div>
//             This is a function component
//             {
//                 jobs.map((job, index) => {
//                     return (
//                         <div key={job.id}>
//                             {job.title} - {job.salary}
//                         </div>
//                     )
//                 })
//             }
//         </div>
//     )
// }

export default ChildComponent;