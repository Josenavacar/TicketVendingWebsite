describe('Login test', function() {
    it('Logs in as a test user', function() {
        cy.visit('http://localhost:3000/login')

        cy.get('input[name=username]').type('testuser')
        cy.get('input[name=password]').type('123456{enter}')
        cy.url()
            .should('includes', '/profile')
        cy.contains('testuser Profile')
        cy.contains('testuser@cypresstest.com')
    })
})