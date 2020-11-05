Steps to run project:
	1. Open project (IntelliJ if possible) and import maven settings so that the java executable is found.
	2. Execute the project.
	3. Open terminal on FrontEnd root directory (./FrontEnd/ticketwebsite-frontend) and type command 'npm start' (Node js installation required).
	4. Proceed to POSTMAN.

Steps to run tests:
	- For unit tests simply select the test on your IDE and run it.
	- For cypress tests, with a terminal enter into the FrontEnd root directory (./FrontEnd/ticketwebsite-frontend) and type command 
'npm run cypress:open' and proceed to click on each test.

Note:
So far only the class of Fan is implemented fully, the reason being that I want to investigate more on how to
connect a database before I continue to program everything else with a fake database.

In order to do CRUD operations I recommend using Postman. This are the different operations:

Create: (POST) localhost:8080/api/v1/fan
	Body:
	{
    		"username": "defaultusername",
    		"password": "defaultpassword",
    		"email": "defaultemail"
	}

Delete: (DELETE) localhost:8080/api/v1/fan/{username}

Update: (PUT) localhost:8080/api/v1/fan/{username}
	Body:
	{
    		"username": "defaultusername",
    		"password": "defaultpassword",
    		"email": "defaultemail"
	}
Get: (GET) localhost:8080/api/v1/fan (All users/fans)
Get: (GET) localhost:8080/api/v1/fan/{username} (Specific user/fan)






This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br />
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br />
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: https://facebook.github.io/create-react-app/docs/code-splitting

### Analyzing the Bundle Size

This section has moved here: https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size

### Making a Progressive Web App

This section has moved here: https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app

### Advanced Configuration

This section has moved here: https://facebook.github.io/create-react-app/docs/advanced-configuration

### Deployment

This section has moved here: https://facebook.github.io/create-react-app/docs/deployment

### `npm run build` fails to minify

This section has moved here: https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify
