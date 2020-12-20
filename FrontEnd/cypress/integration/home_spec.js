describe('Home page test', function () {
    it('Finds default elements', function () {
        cy.visit('http://localhost:3000/home')

        cy.contains('Home')
        cy.url()
            .should('includes', '/home')
    })
})