import logo from './logo.svg';
import './App.scss';
import TestComponent from './examples/TestComponent';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <a>
          <TestComponent />
        </a>
      </header>
    </div>
  );
}

export default App;
