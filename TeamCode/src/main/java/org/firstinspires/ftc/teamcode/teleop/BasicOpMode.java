package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.BaseOpMode;


@TeleOp(name = "BasicOpMode", group = "Test")
public class BasicOpMode extends BaseOpMode {

    private boolean shooterOn = false;
    private double flywheelSpeed = 1;

    @Override
    public void loop() {
        // Slow mode lambda toggle
        teleop.runOncePerPress(gamepad1.a, () -> mecanumDrive.toggleSlowMode());

        // Toggles the shooter on or off
        teleop.runOncePerPress(gamepad1.x, () -> shooterOn = !shooterOn);

        if(shooterOn) {
            flyLeft.setPower(flywheelSpeed);
            flyRight.setPower(flywheelSpeed);
        }

        else{
            flyLeft.setPower(0);
            flyRight.setPower(0);
        }

        // Send commands to the mecanum drive base
        super.mecanumDrive.fieldCentricControl(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, getGyroYaw());

        // Leave this here as it resets all the values for the next loop
        super.teleop.endPeriodic();
    }


}