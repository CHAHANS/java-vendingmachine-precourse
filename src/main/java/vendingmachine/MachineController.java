package vendingmachine;

import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MachineService machineService;
    MachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.machineService = new MachineService();
    }

    public void setMachineCoin() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        machineService.initMachine(inputView.userInputNumber());
        System.out.println();
        outputView.printNowCoin(machineService.getMachineCoin());
    }

    public void setMachineProduct() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        machineService.addProducts(inputView.userInputProductSetting());
        System.out.println();
        System.out.println("투입 금액을 입력해 주세요.");
        machineService.addPay(inputView.userInputNumber());
    }

    public void buyProduct() {
        while(true) {
            System.out.println("투입 금액: " + machineService.getMachine().getWallet() + "원");
            System.out.println("구매할 상품명을 입력해 주세요.");
            machineService.selling(inputView.userInputProduct());
            if (!(machineService.getMachine().buyAnyChecker())) {
                break;
            }
        }
        outputView.printChangeCoin(
                machineService.getMachine().getWallet(),
                machineService.giveChange()
        );
    }

}
