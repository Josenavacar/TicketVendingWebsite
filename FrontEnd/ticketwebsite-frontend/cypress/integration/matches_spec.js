describe('Match load test', function () {
    it('Finds default match', function () {
        cy.visit('http://localhost:3000/matches')

        cy.contains('Valencia vs. Barcelona')
        cy.url()
            .should('includes', '/matches')
    })
})