const { chromium } = require('playwright');

(async () => {
  const browser = await chromium.launch();
  const context = await browser.newContext({
    storageState: 'state.json'
  });

  const page = await context.newPage();
  await page.goto('https://sandbox.cubeforall.com/products/forwarders-shippers/freight-x');
  await page.screenshot({ path: 'freight-dashboard.png' });

  await browser.close();
})();