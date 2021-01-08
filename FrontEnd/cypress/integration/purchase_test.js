require('cypress-plugin-tab');

describe('Login and purchase test', function () {
    it('Logs in and buys an item as testuser', function () {
        cy.visit('http://localhost:3000/login')

        cy.get('input[name=username]').type('testuser')
        cy.get('input[name=password]').type('123456{enter}')
        cy.tab()
        cy.type('{enter}')
    })
})