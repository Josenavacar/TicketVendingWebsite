describe('Login Page test', function () {
    it('Checks default items', function () {
        cy.visit('http://localhost:3000/login')

        cy.contains('Username')
        cy.contains('Password')
        cy.url()
            .should('includes', '/login')
    })
})